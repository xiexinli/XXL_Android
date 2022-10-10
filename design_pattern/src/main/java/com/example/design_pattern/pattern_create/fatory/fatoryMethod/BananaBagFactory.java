package com.example.design_pattern.pattern_create.fatory.fatoryMethod;

import com.example.design_pattern.entity.Bag;
import com.example.design_pattern.entity.bag.BananaBag;

/**
 * 工厂方法模式
 */
public class BananaBagFactory implements BagFactory{
    public Bag getBag(){
        return new BananaBag();
    }
}
