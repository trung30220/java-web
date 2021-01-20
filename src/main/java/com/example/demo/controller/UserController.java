package com.example.demo.controller;

import com.example.demo.mapping.simple.UserMapper;
import com.example.demo.models.OldUser;
import com.example.demo.pojo.UserDto;
import com.example.demo.repositories.OldUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    OldUserRepository oldUserRepository;

    @PostMapping("/user/save")
    String saveUser(@RequestBody UserDto userDto) {
        OldUser oldUser = UserMapper.dtoToEntity(userDto);
        oldUserRepository.save(oldUser);
        return "success";
    }
}
