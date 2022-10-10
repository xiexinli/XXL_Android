package com.example.design_pattern.pattern_create.fatory.fatoryMethod;

import com.example.design_pattern.entity.fruit.Apple;
import com.example.design_pattern.entity.Fruit;

/**
 * 工厂方法模式
 */
public class AppleFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Apple();
    }
}
