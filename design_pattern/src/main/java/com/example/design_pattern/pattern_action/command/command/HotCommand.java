package com.example.design_pattern.pattern_action.command.command;

import com.example.design_pattern.pattern_action.command.Command;
import com.example.design_pattern.pattern_action.command.handler.HotHandler;

public class HotCommand extends Command {
    private HotHandler handler = new HotHandler();

    @Override
    public String execute() {
        return handler.getHots();
    }
}
