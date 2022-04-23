package com.fc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String info;
}
