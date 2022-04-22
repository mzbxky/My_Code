package com.fc;

import com.fc.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public Map<String,Object> login(String username,String password){
        Map<String ,Object> result = new HashMap<>();
        Map<String,Object> claim = new HashMap<>();
        //如果相等，就是管理员，否则就是普通用户
        if(username.equals("黑小虎") && password.equals("123456")){
            claim.put("auth","admin");
        }else {
            claim.put("auth","user");
        }
        //创建token
        String token = JwtUtil.getToken(claim,"mzb");
        result.put("token",token);
        result.put("code",200);
        result.put("success",true);
        return result;
    }
    @RequestMapping("show")
    public Map<String,Object> verify(String token){
        Map<String,Object> map = JwtUtil.verify(token,"mzb");
        Map<String,Object> result = new HashMap<>();
       Boolean success = (Boolean) map.get("success");
       if (success){
           result.put("code",200);
           result.put("success",true);
           result.put("message","token验证成功");
       }else {
           result.put("code",-1);
           result.put("success",false);
           result.put("message","token验证失败");
       }
        return result;
    }
//@RequestMapping("add")
//public Map<String ,Object> add(String token){
//        Map<String,Object> map = JwtUtil.verify(token,"mzb");
//    System.out.println(map);
//    Boolean success = (Boolean) map.get("success");
//    if(success){
//        Map<String,Object> data = (Map<String, Object>) map.get("data");
//        System.out.println(data);
//        String auth = (String) data.get("auth");
//        if(auth.equals("admin")){
//            map.put("message","Welcome Admin");
//        }else {
//            map.put("message","No Auth");
//        }
//    }else {
//        map.put("message","Invalid Token");
//    }
//    return map;
//
//}
//@RequestMapping("show")
//    public Map<String,Object> show(String token){
//        Map<String,Object> map = JwtUtil.verify(token,"mzb");
//        Boolean success = (Boolean) map.get("success");
//        if (success){
//            map.put("message","Welcome LookLook");
//        }else {
//            map.put("message","Invalid Token");
//        }
//        return map;
//}

}
