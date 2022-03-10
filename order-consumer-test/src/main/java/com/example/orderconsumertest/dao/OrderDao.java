package com.example.orderconsumertest.dao;

import com.example.orderconsumertest.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    public int insertOrder(Order order);
    public int updateOrder(Order order);
    public List<Order> getOrderWhichSuccessFalse();
}
