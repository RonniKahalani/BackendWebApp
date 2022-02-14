package com.example.backend.command;

public interface ICommand {

    public long getId();

    public String getName();

    public String getScript();

    public String getDescription();

    public String getArgs();

}
