package com.example.orderconsumertest.service;

import com.example.orderconsumertest.model.Order;

import java.util.List;

public interface OrderService {
    public String addOrder(Order order);
    public int insertOrder(Order order);
    public int updateOrder(Order order);
    public List<Order> getOrderFalse();

}
