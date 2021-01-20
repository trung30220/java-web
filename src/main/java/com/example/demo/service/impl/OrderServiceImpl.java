package com.example.demo.service.impl;

import com.example.demo.mapping.simple.CatalogueMapping;
import com.example.demo.mapping.simple.OrderMapping;
import com.example.demo.models.Catalogue;
import com.example.demo.models.Order;
import com.example.demo.pojo.CatalogueDto;
import com.example.demo.pojo.OrderDto;
import com.example.demo.repositories.CatalogueRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(OrderDto orderDto) {
        Order order = OrderMapping.dtoToEntity(orderDto);
        return orderRepository.save(order);
    }

    @Autowired
    CatalogueRepository catalogueRepository;

    public Catalogue save(CatalogueDto object) {
        Catalogue catalogue = CatalogueMapping.dtoToEntity(object);

        // set parent
        Catalogue parent = catalogueRepository.getOne(object.getParentId());
        catalogue.setCatalogue(parent);

        catalogueRepository.save(catalogue);
        return catalogue;
    }


}
