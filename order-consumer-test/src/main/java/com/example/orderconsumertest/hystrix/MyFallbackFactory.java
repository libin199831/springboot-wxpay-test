package com.example.orderconsumertest.hystrix;

import com.example.orderconsumertest.model.Order;
import com.example.orderconsumertest.service.SaleService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackFactory implements FallbackFactory<SaleService> {
    @Override
    public SaleService create(Throwable cause) {
        return new SaleService() {
            @Override
            public String getResult(Order order) {
                return "服务降级";
            }
        };
    }
}
