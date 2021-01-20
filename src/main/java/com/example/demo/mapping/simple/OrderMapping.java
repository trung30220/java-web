package com.example.demo.mapping.simple;

import com.example.demo.models.Order;
import com.example.demo.pojo.OrderDto;

public class OrderMapping {
    public static OrderDto entityToDto(Order object) {
        OrderDto result = new OrderDto();
        result.setAmount(object.getAmount());
        result.setId(object.getId());
        result.setUserId(object.getOldUser().getId());
        return result;
    }
    public static Order dtoToEntity(OrderDto object) {
        Order result = new Order();
        result.setAmount(object.getAmount());
        result.setId(object.getId());
//        result.setUserId(object.getUser().getId());
        return result;
    }
}
