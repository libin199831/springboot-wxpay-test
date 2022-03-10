package com.example.orderconsumertest.service.impl;

import com.example.orderconsumertest.dao.OrderDao;
import com.example.orderconsumertest.model.Order;
import com.example.orderconsumertest.service.OrderService;
import com.example.orderconsumertest.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    //@Autowired
    @Resource
    private SaleService saleService;

    /*@Override
    public String addOrder(Order order) {
        String str=saleService.getResult(order);
        if(str==null || "服务降级".equals(str)){
            return "default";
        } else{
            int count = orderDao.insertOrder(order);
            if(count>0){
                String msg=saleService.getResult(order);
                if("success8001".equals(msg) || "success8002".equals(msg)){
                    order.setSuccess(true);
                    orderDao.updateOrder(order);
                }
                return msg;
            }
        }
        return "default";
    }*/

    @Override
    public String addOrder(Order order) {
        int count = orderDao.insertOrder(order);
        if(count>0){
            String msg=saleService.getResult(order);
            if("success8001".equals(msg) || "success8002".equals(msg)){
                order.setSuccess(true);
                orderDao.updateOrder(order);
            }
            return msg;
        }
        return "default";
    }
    @Override
    public int insertOrder(Order order){
        return orderDao.insertOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public List<Order> getOrderFalse() {
        return orderDao.getOrderWhichSuccessFalse();
    }
}
