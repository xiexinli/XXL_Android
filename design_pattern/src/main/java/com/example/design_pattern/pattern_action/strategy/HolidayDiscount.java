package com.example.design_pattern.pattern_action.strategy;

/**
 * ćæ„ćšć
 */
public class HolidayDiscount implements Discount {
    @Override
    public int calculate(int money) {
        if (money > 100){
            return money - 20;
        }
        return money;
    }
}
