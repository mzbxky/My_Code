package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    //用户添加
    @RequestMapping("add")
    public Map<String,Object> addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping("del")

    //删除用户
public Map<String,Object> deleteUser(Long id){

    return userService.delete(id);
}
//修改用户
    @RequestMapping(value = "update" ,consumes = "application/json;charset=UTF-8")
    public Map<String ,Object> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //用户获取
    @RequestMapping("list")

    public Map<String,Object> findAll(Integer pageNo,Integer pageSize){

        return userService.findAll(pageNo,pageSize);
    }
}
