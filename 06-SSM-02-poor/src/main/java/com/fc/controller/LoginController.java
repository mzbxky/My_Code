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
    public Map<String, Object> login(String username, String password){
        Map<String,Object> claim = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        User user = userMapper.selectUser(username);
        if (user == null){

            map.put("code",-1);
            map.put("message","用户名不存在");
            map.put("success",false);
            map.put("data",null);
            map.put("time",null);
        }else {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                String token = JwtUtil.getToken(claim,"qwertyu");
                Long time = System.currentTimeMillis() + 1000 * 200000;
                map.put("code",1);
                map.put("message","登录成功");
                map.put("success",true);
                map.put("data",token);
                map.put("time",time);

            }else {

                map.put("code",-1);
                map.put("message","用户名或密码错误");
                map.put("success",false);
                map.put("data",null);
                map.put("time",null);
            }
        }
        return map;
    }
    @RequestMapping("verify")
    public ResultVo verify(String token){
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
