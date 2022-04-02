package com.fc.service;

import com.fc.entity.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> delete(Long id);

    Map<String,Object> updateUser(User user);

    Map<String,Object> addUser(User user);

    Map<String,Object> findAll(Integer pageNo,Integer pageSize);
}
