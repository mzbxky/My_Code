package com.fc.service.impl;

import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加了一个用户 爷傲奈我何");
    }

    @Override
    public void update() {
        System.out.println("修改了用户信息 爷傲奈我何");
    }
}
