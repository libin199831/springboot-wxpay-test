package com.example.orderconsumertest.hystrix;

import com.example.orderconsumertest.model.Order;
import com.example.orderconsumertest.service.SaleService;
import org.springframework.stereotype.Component;

@Component
public class MyFallback implements SaleService {
    @Override
    public String getResult(Order order) {
        return "服务降级";
    }
}
