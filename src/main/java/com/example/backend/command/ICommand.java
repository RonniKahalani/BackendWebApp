package com.example.backend.command;

public interface ICommand {

    long getId();

    String getName();

    String getScript();

    String getDescription();

    String getArgs();

}
