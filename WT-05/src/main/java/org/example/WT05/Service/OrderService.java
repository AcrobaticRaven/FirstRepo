package org.example.WT05.Service;

import org.example.WT05.Model.Order;
import org.example.WT05.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepo iOrderRepo;

    public void addOrder(Order order){
        iOrderRepo.save(order);
    }

    public String getOrder(Integer Id){
        Optional<Order>OrderOptional = iOrderRepo.findById(Id);
        if(OrderOptional.isPresent()){
            Order order = OrderOptional.get();
            return order.toString();
        }return "Order not found";
    }
}
