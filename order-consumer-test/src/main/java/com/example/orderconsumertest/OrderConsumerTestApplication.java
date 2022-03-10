package com.example.orderconsumertest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.orderconsumertest.dao")
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
public class OrderConsumerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerTestApplication.class, args);
    }

}
