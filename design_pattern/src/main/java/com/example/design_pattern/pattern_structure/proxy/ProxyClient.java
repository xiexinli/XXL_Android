package com.example.design_pattern.pattern_structure.proxy;

import com.example.design_pattern.service.OrderService;

/**
 * 代理模式
 * 代售进口水果
 */
public class ProxyClient {
    public static void main(String[] args){
        saveOrder();
    }

    public static void saveOrder(){
        //本地代理类
        OrderService orderService = new ProxyOrder();

        orderService.saveOrder();

        //其它业务代码。。。。

    }



}
