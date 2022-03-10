package com.example.orderconsumertest.service;

import com.example.orderconsumertest.hystrix.MyFallback;
import com.example.orderconsumertest.hystrix.MyFallbackFactory;
import com.example.orderconsumertest.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "EUREKA-PROVIDER",fallback = MyFallback.class)
//@FeignClient(name = "EUREKA-PROVIDER",fallbackFactory = MyFallbackFactory.class)
public interface SaleService {
    @RequestMapping("/saleController")
    String getResult(@RequestBody Order order);

}
