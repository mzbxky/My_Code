package com.fc.service.impl;

import com.fc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加了一个新用户 爷傲奈我何");
    }

    @Override
    public void update() {
        System.out.println("更改了 爷傲奈我何");
    }
}
