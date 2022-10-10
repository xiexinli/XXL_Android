package com.example.design_pattern.entity;

import com.example.design_pattern.pattern_action.visit.Visit;

/**
 * 水果接口
 */
public interface Fruit {

    int price();

    void draw();

    int accept(Visit visit);

}
