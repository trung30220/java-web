package com.example.demo.controller;

import com.example.demo.models.OldUser;
import com.example.demo.models.Order;
import com.example.demo.pojo.OrderDto;
import com.example.demo.repositories.OldUserRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OldUserRepository oldUserRepository;

    @PostMapping("/order/add")
    String addOrder(@RequestBody OrderDto orderDto) {
//        Order order = OrderMapper.dtoToEntity(orderDto);
        Order order = new Order();
        order.setAmount(orderDto.getAmount());


        Optional<OldUser> user = oldUserRepository.findById(orderDto.getUserId());
        if (user.isPresent()) {
            order.setOldUser(user.get());
            orderRepository.save(order);
        }
        return "success";
    }
}
