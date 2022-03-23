package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
//用于把当前类对象存入Spring容器中。value属性：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写
@Component
public class User {
    @Value("1")
private Integer id;
    @Value("阿拉斯加")
private String name;
    @Value("123465")
private String password;
}
