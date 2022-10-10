package com.example.design_pattern.pattern_create.fatory.fatoryMethod;

import com.example.design_pattern.entity.Fruit;
import com.example.design_pattern.entity.fruit.Orange;

/**
 * 工厂方法模式
 */
public class OrangeFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Orange("Peter",80);
    }
}
