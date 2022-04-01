package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("del")
    @ResponseBody
    //删除用户
public Map<String,Object> deleteUser(Long id){
        Map<String , Object> map = new HashMap<>();
        if (userService.delete(id) != 1){
            map.put("message","用户删除失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
        }
        map.put("message","用户删除成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
    return map;
}
//修改用户
    @RequestMapping(value = "update" ,consumes = "application/json;charset=UTF-8")
    public Map<String ,Object> updateUser(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        if(userService.updateUser(user) != 1){
            map.put("message","用户修改失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户修改成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;
    }
    //用户添加
    @RequestMapping("add")

    public Map<String,Object> addUser(User user){
        Map<String,Object> map = new HashMap<>();
        if(userService.addUser(user) != 1){
            map.put("message","用户添加失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户添加成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data","{}");
        return map;
    }
    //用户获取
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findAll(Integer pageNum,Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        if (userService.findAll(pageNum,pageSize) == null){
            map.put("message","用户获取失败");
            map.put("code",404);
            map.put("success",false);
            map.put("data", "{错误描述}");
            return map;
        }
        map.put("message","用户获取成功");
        map.put("code",200);
        map.put("success",true);
        map.put("data:",userService.findAll(pageNum,pageSize));
        return map;
    }
}
