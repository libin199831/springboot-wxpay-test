package com.example.orderconsumertest.controller;

import com.example.orderconsumertest.model.Order;
import com.example.orderconsumertest.service.OrderService;
import com.example.orderconsumertest.service.SaleService;
import com.example.orderconsumertest.thread.OrderCheckThread;
import com.example.orderconsumertest.utils.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Resource
    private SaleService saleService;

    @RequestMapping("/toOrder")
    public String toOrder(){
        return "order";
    }
//你觉得把业务代码放在控制层合理吗
    @RequestMapping("/makeOrder")
    public String makeOrder(@RequestParam("username")String username,
                            @RequestParam("shopName")String shopName,
                            @RequestParam("money")String money, Model model){
        Order order=new Order(OrderUtil.getOrderId(),username,shopName,money,false);
        String msg=orderService.addOrder(order);
        model.addAttribute("msg",msg);
        return "attention";
    }
}
