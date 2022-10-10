package com.example.design_pattern.pattern_create.fatory.abstractFactory;

import com.example.design_pattern.entity.Bag;
import com.example.design_pattern.entity.Fruit;
import com.example.design_pattern.entity.bag.OrangeBag;
import com.example.design_pattern.entity.fruit.Orange;

/**
 * 水果工厂
 */
public class OrangeFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Orange("Peter",50);
    }

    @Override
    public Bag getBag() {
        return new OrangeBag();
    }
}
