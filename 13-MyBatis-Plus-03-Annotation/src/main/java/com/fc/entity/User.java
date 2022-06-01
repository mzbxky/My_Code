package com.fc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
//@TableName(value = "tb_user",keepGlobalPrefix = false)
public class User {
private Integer id;
private String username;
@TableField(value = "password")
private String pwd;
private String nick;
private String mood;
@TableLogic
private Boolean availability;
}
