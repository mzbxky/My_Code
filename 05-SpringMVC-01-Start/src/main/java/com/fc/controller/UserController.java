package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@Controller
//用于声明请求的映射url请求路径,也能加/，可以不加
//@RequestMapping("user")
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public String login(){
        System.out.println("登录成功");
        return "/login.jsp";
    }
    @RequestMapping("register")
    public String register(){
        System.out.println("注册成功");
        return "/login.jsp";
    }
    @RequestMapping("delete")
    public String delete(){
        System.out.println("删除成功");
        return "/login.jsp";
    }
}
