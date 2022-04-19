package com.fc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private String name;
    @Value("${student.hobby[0]}")
    private String hobby;
    @Value("${student.car.name}")
    private String CarName;
    @Value("${student.food[0]}")

    private String score;
    @RequestMapping("test")
    public Map<String, Object> testYml() {
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("hobby",hobby);
        map.put("CarName",CarName);

        map.put("score",score);
        return map;
    }
}
