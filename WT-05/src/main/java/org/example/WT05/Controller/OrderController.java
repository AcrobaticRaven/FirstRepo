package org.example.WT05.Controller;

import org.example.WT05.Model.Order;
import org.example.WT05.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("Order")
    public void addOrder(Order order){
        orderService.addOrder(order);
    }

    @GetMapping("Order")
    public String getOrder(Integer Id){
        return orderService.getOrder(Id);
    }
}
