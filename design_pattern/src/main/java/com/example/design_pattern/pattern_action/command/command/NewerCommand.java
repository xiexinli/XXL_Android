package com.example.design_pattern.pattern_action.command.command;

import com.example.design_pattern.pattern_action.command.Command;
import com.example.design_pattern.pattern_action.command.handler.NewerHandler;

public class NewerCommand extends Command {
    private NewerHandler handler = new NewerHandler();

    @Override
    public String execute() {
        return handler.getNewers();
    }
}
