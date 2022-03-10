package com.example.orderconsumertest.thread;

import com.example.orderconsumertest.model.Order;
import com.example.orderconsumertest.service.OrderService;
import com.example.orderconsumertest.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class OrderCheckThread implements Runnable{
    @Autowired
    private OrderService orderService;
    @Resource
    private SaleService saleService;
    @PostConstruct
    public void init(){
        new Thread(this).start();
    }
    /*static{
        new Thread(this).start();
    }*/
    @Override
    public void run() {
        while(true){
            List<Order> list= orderService.getOrderFalse();
            if(!list.isEmpty()){
                for(Order order:list){
                    String str=saleService.getResult(order);
                    if("success8001".equals(str) || "success8002".equals(str)){
                        order.setSuccess(true);
                        orderService.updateOrder(order);
                    }
                }
            }
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
