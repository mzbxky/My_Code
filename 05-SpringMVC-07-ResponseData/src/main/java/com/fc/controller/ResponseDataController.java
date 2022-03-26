package com.fc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("user")
public class ResponseDataController {
    @RequestMapping("testVoid")
    public void testVoid(){
        System.out.println("测试testVoid");
    }
    @RequestMapping("testString")
public String testString(){
    System.out.println("测试String直接返回路径");
    return "/success.jsp";
}
@RequestMapping("testModelAndView")
public ModelAndView testModelAndView(){
        //模型和视图对象
    ModelAndView mv = new ModelAndView("/success.jsp");
    mv.addObject("username","黑小虎");
    return mv;
}
@RequestMapping("testModelAndView1")
//可以通过方法的形参直接获取
public ModelAndView testModelAndView1(ModelAndView mv){
        mv.addObject("username","沸羊羊");
        mv.setViewName("/success.jsp");
        return mv;
}
//直接使用Model以及字符串跳转页面
    @RequestMapping("testModelAndView2")
public String testModelAndView2(Model model){
        //设置模型
        model.addAttribute("username","双面龟");

        return "/success.jsp";
}
@RequestMapping("testStringRedirect")
public String testStringRedirect(){
        return "redirect:/success.jsp";
}

@RequestMapping("testStringForward")
public String testStringForward(){
        return "forward:/success.jsp";
}
    @RequestMapping("testResponseBody")
    //直接跳过事务解析器
    @ResponseBody
    public void testResponseBody() {
        System.out.println("测一下，看看还报不报错");
    }
    @RequestMapping(value = "testStringByResponseBody", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String testStringByResponseBody() {
        return "<h1 align='center' style='color: green'>易烊千玺</h1>";
    }
    @RequestMapping(value = "getJsonString",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJsonString(){
        User user = new User();
        user.setName("黑小虎");
        user.setAge(12);
        user.setBirthday(new Date());
        user.setGender("男");
        user.setInfo("几个字");
        // 对象映射器
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
    @RequestMapping(value = "getJsonObject", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public User getJsonObject() {
        User user = new User();
        user.setName("沸羊羊");
        user.setAge(12);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("几个字");

        return user;
    }
    @RequestMapping(value = "getJsonMap",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String , Object> testJsonMap(){

            Map<String, Object> map = new HashMap<>();

            User user = new User();
            user.setName("易烊千玺");
            user.setAge(22);
            user.setGender("男");
            user.setBirthday(new Date());
            user.setInfo("四个字");

            List<String> foods = new ArrayList<>();
            foods.add("火腿肠");
            foods.add("咸鸭蛋");
            foods.add("面包");
            foods.add("牛奶");
            foods.add("馒头");

            map.put("code", 200);
            map.put("message", "查询成功");
            map.put("data", user);
            map.put("foods", foods);
        return map;
    }
}
