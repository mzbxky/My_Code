package com.fc.advice;

import com.fc.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
//对controller进行增强

public class ExceptionAdvice {
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Map<String ,Object> handleMyException(){
        Map<String, Object> map = new HashMap<>();

        map.put("code", -1);
        map.put("message", "自定义异常");
        map.put("success", false);
    return map;
    }
    // 用于处理系统异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", -1);
        map.put("message", e.getMessage());
        map.put("success", false);

        return map;
    }
}
