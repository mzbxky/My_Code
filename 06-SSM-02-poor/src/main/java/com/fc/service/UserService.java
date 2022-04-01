package com.fc.service;

import com.fc.entity.User;

import java.util.List;

public interface UserService {
    Integer delete(Long id);

    Integer updateUser(User user);

    Integer addUser(User user);

    List<User> findAll(Integer pageNum,Integer pageSize);
}
