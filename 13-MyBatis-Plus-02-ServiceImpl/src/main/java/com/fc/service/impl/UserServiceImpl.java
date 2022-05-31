package com.fc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
