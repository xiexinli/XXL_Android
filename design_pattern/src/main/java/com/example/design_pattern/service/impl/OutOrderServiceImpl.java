package com.example.design_pattern.service.impl;

import com.example.design_pattern.service.OrderService;

/**
 * 海外订单
 */
public class OutOrderServiceImpl implements OrderService {
    @Override
    public int saveOrder() {
        System.out.println("下单成功，订单号： 66666666");
        return 66666666;
    }
}
