package com.example.backend.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommandController {
    private final CommandService commandService;


    CommandController(CommandService commandService) {

        this.commandService = commandService;
    }

    @GetMapping("/cmd")
    List<ICommand> viewAllCommands() {
        return commandService.getAll();
    }

    @GetMapping(value = "/cmd/{id}")
    ICommand viewCommand(@PathVariable long id) {
        return commandService.getById((int) id);
    }

    @GetMapping(value = "/cmd/{id}/run", produces = MediaType.TEXT_PLAIN_VALUE)
    String runCommand(@PathVariable long id) {
        return commandService.execute(commandService.getById((int) id));
    }

}

