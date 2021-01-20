package com.example.demo.mapping.simple;

import com.example.demo.models.OldUser;
import com.example.demo.pojo.UserDto;

public class UserMapper {
    public static OldUser dtoToEntity(UserDto userDto) {
        OldUser oldUser = new OldUser();
        oldUser.setId(userDto.getId());
        oldUser.setAddress(userDto.getAddress());
        oldUser.setName(userDto.getName());
        oldUser.setPassword(userDto.getPassword());
        return oldUser;
    }
}
