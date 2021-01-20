package com.example.demo.service;

import com.example.demo.models.Order;
import com.example.demo.pojo.OrderDto;

public interface OrderService {
    Order saveOrder(OrderDto orderDto);
}
