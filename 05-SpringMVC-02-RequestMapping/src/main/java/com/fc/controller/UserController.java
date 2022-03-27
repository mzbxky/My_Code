package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("getParam")
    public void getParam(String username,String password){

        System.out.println("用户名：" + username + " 密码：" + password);
    }
}
