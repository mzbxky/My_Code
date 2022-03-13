package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
//员工类
public class Department {
    private Integer id;
    private String name;
    //员工类里有一个部门类型，
    private List<Employee> employees;
}
