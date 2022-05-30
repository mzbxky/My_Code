package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
@Api(value = "userController" ,description = "用户相关的操作")

public class UserController {
    @Autowired
    private UserService userService;
    //用户添加
    @PostMapping("add")
    @ApiOperation("添加用户")
    public ResultVo addUser(@ApiParam(name = "user",value = "用户对象")@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("delete")
@ApiOperation("删除用户")
    //删除用户
public ResultVo deleteUser(@ApiParam(name = "id",value = "用户的编号") @RequestParam Long id){

    return userService.delete(id);
}
//修改用户
    @PostMapping(value = "update" ,consumes = "application/json;charset=UTF-8")
    @ApiOperation("修改用户")
    public ResultVo updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //用户获取
    @GetMapping("getlist")
@ApiOperation("查询用户")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize,
                            String info ,String search,Long id){

        return userService.getList(pageNum,pageSize,info,search,id);
    }

    public ResultVo login(@RequestParam String username,@RequestParam String password){

    return userService.login(username,password);
}
}
