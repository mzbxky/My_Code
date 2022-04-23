package com.fc.service;

import com.fc.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo<com.fc.entity.User> findAll(Integer pageNum, Integer pageSize);

    int add(com.fc.entity.User user);

    int update(User user);

    int delete(Integer id);
}
