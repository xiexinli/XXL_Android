package com.example.design_pattern.pattern_action.template;

import com.example.design_pattern.pattern_action.strategy.Discount;
import com.example.design_pattern.pattern_action.strategy.FullDiscount;
import com.example.design_pattern.pattern_action.strategy.NewerDiscount;
import com.example.design_pattern.pattern_action.strategy.SecondDiscount;
import com.example.design_pattern.pattern_create.fatory.simple.StaticFactory;
import com.example.design_pattern.entity.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板方法模式
 * 订单费用结算过程
 */
public class ShoppingCartClient {

    private static Map<String,Discount> disCounts = new HashMap();
    static {
        disCounts.put("full",new FullDiscount());
        disCounts.put("newer",new NewerDiscount());
        disCounts.put("second",new SecondDiscount());
    }

    public static void main(String[] args) {
        List<Fruit> products = new ArrayList();

        products.add(StaticFactory.getFruitApple());
        products.add(StaticFactory.getFruitBanana());
        products.add(StaticFactory.getFruitOrange());

        ShoppingCart cart = new OtherPayShopping(products);

        //注入优惠方案
//        String discount = "second";
//        cart.setDiscount(disCounts.get(discount));

        cart.submitOrder();
    }


}
