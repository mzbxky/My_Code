package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("test")
    @ResponseBody
    public String test(ModelAndView mv){
        System.out.println("Controller正在执行");

        return "出来个东西";
    }
}
