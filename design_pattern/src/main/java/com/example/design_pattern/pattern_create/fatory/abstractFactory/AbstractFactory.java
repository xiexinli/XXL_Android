package com.example.design_pattern.pattern_create.fatory.abstractFactory;

import com.example.design_pattern.entity.Bag;
import com.example.design_pattern.entity.Fruit;

/**
 * 抽象水果工厂
 */
public abstract class AbstractFactory {

    public abstract  Fruit getFruit();

    public abstract Bag getBag();

}
