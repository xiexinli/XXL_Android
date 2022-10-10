package com.example.design_pattern.pattern_create.fatory.abstractFactory;

import com.example.design_pattern.entity.Bag;
import com.example.design_pattern.entity.Fruit;
import com.example.design_pattern.entity.bag.BananaBag;
import com.example.design_pattern.entity.fruit.Banana;

/**
 * 水果工厂
 */
public class BananaFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Banana();
    }

    @Override
    public Bag getBag() {
        return new BananaBag();
    }
}
