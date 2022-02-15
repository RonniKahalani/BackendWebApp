package com.example.backend.command;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandService {
    private List<ICommand> cmds = new ArrayList<ICommand>();

    public CommandService() {
        cmds.add(new Command(0, "Show C-Drive", "dir", "Lists root of the C-Drive.", "c:\\"));
        cmds.add(new Command(1, "Show Help File", "type", "Types the content of a help file.", "c:\\code\\backend\\help.md"));
        cmds.add(new Command(2, "Show Code Folder", "dir", "Lists the content of the code folder.", "c:\\code"));
    }

    public String execute(ICommand command) {
        StringBuilder reply = new StringBuilder("Executing command: " + command + "\n");
        BufferedReader inputReader;
        String line;
        ProcessBuilder processBuilder = new ProcessBuilder();

        try {

            processBuilder.command("cmd.exe", "/c", command.getScript(), command.getArgs());
            Process process = processBuilder.start();

            // Read input stream.
            inputReader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));

            while ((line = inputReader.readLine()) != null) {
                reply.append(line).append("\n");
            }
            inputReader.close();

            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("Abnormal process termination");

                // Read error stream.
                inputReader = new BufferedReader(new InputStreamReader(
                        process.getErrorStream()));
                line = null;
                while ((line = inputReader.readLine()) != null) {
                    reply.append(line).append("\n");
                }
                inputReader.close();

            }
/*

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream()));
            writer.write("09-20-14");
            writer.close();
*/

        } catch (Exception e) {
            reply.append(e.getMessage().toString());
        }
        return reply.toString();
    }

    public List<ICommand> getAll() {
        return cmds;
    }

    public ICommand getById(int id) {
        return cmds.get(id);
    }

}
