package com.example.demo.mapping.simple;

import com.example.demo.models.Order;
import com.example.demo.pojo.OrderDto;

public class OrderMapper {
    public static Order dtoToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setAmount(orderDto.getAmount());

//        orderDto.getUserId();
        return order;
    }
}
