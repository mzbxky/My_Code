package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1,"阿拉斯加","132456"));
        list.add(new User(2,"拉布拉多","3.14"));

        return list;
    }
}
