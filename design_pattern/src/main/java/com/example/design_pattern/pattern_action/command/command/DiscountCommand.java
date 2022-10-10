package com.example.design_pattern.pattern_action.command.command;

import com.example.design_pattern.pattern_action.command.Command;
import com.example.design_pattern.pattern_action.command.handler.DiscountHandler;

public class DiscountCommand extends Command {

    private DiscountHandler handler = new DiscountHandler();

    @Override
    public String execute() {
        return handler.getDiscounts();
    }
}
