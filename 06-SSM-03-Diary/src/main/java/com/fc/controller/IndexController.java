package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;
    public String find(User user){
        return "/index.jsp";
    }

}
