package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class UserController {
    //自动按照类型注入（首字母小写）前提是必须在Spring容器中存在这个对象才行
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> findAll() {
        return userService.findAll();
    }
}
