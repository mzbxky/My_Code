package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    //用户添加
    @PostMapping("add")
    public ResultVo addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("delete")

    //删除用户
public ResultVo deleteUser(Long id){

    return userService.delete(id);
}
//修改用户
    @PostMapping(value = "update" ,consumes = "application/json;charset=UTF-8")
    public ResultVo updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //用户获取
    @GetMapping("getlist")

    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize,
                            String info ,String search,Long id){

        return userService.getList(pageNum,pageSize,info,search,id);
    }


}
