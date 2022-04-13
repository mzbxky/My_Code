package com.fc.controller;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.util.JwtUtil;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("login")
    public ResultVo login(String username, String password){
        ResultVo resultVo = null;
//        Map<String ,Object> result = new HashMap<>();
        Map<String,Object> claim = new HashMap<>();

        User user = userMapper.selectUser(username);
        if (user == null){
            resultVo = new ResultVo(-1,"用户不存在",false,null);
        }else {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                String token = JwtUtil.getToken(claim,"qwertyu");
                resultVo = new ResultVo(200,"登录成功",true,token);

            }else {
                resultVo = new ResultVo(-1,"用户名或密码错误",false,null);
            }
        }
        return resultVo;
    }
    @RequestMapping("add")
    public ResultVo add(String token){
        ResultVo resultVo;
        Map<String,Object> map = JwtUtil.verify(token,"qwertyu");
        Boolean success = (Boolean) map.get("success");
        if(success){
            resultVo = new ResultVo(200,"token未过期",true,null);
        }else {
            resultVo = new ResultVo(-1,"token已过期请重新登录",false,null);
        }
        return resultVo;

    }
}
