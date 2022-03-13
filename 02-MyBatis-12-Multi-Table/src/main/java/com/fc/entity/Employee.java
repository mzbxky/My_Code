package com.fc.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    //部门类里有一个员工类型的
    private Department department;
}
