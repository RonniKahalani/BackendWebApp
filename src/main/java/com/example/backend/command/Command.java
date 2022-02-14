package com.example.backend.command;

public class Command implements ICommand {
    long id;
    String name;
    String script;
    String description;
    String args;

    public Command(long id, String name, String script, String description, String args) {
        this.id = id;
        this.name = name;
        this.script = script;
        this.description = description;
        this.args = args;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getScript() {
        return script;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", script='" + script + '\'' +
                ", description='" + description + '\'' +
                ", args='" + args + '\'' +
                '}';
    }
}
