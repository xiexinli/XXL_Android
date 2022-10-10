package com.example.design_pattern.pattern_structure.proxy;

import com.example.design_pattern.service.OrderService;
import com.example.design_pattern.service.impl.OutOrderServiceImpl;

public class ProxyOrder implements OrderService {

    //真实的订单服务
    private OrderService orderService = new OutOrderServiceImpl();

    @Override
    public int saveOrder() {
        System.out.println("开始海外下订单");
        return orderService.saveOrder();
    }
}
