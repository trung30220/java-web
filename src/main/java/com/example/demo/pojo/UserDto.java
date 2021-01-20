package com.example.demo.pojo;

import com.example.demo.models.Order;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String address;
    private String password;
    private String phone;
    private String gender;
    private Set<Order> orders;
}
