package com.esp.service;

import java.util.List;

import com.esp.model.User;
import com.esp.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(String id);

    User findOne(String username);

    User findById(String id);

    UserDto update(UserDto userDto);
    
	User findByEmail(String email);
}
