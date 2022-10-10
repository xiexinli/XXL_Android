package com.example.design_pattern.pattern_create.fatory.abstractFactory;

import com.example.design_pattern.entity.Bag;
import com.example.design_pattern.entity.Fruit;
import com.example.design_pattern.entity.bag.AppleBag;
import com.example.design_pattern.entity.fruit.Apple;

/**
 * 水果工厂
 */
public class AppleFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
