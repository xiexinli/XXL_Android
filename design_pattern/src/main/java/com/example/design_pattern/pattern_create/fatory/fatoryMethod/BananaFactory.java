package com.example.design_pattern.pattern_create.fatory.fatoryMethod;

import com.example.design_pattern.entity.fruit.Banana;
import com.example.design_pattern.entity.Fruit;

/**
 * 工厂方法模式
 */
public class BananaFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Banana();
    }
}
