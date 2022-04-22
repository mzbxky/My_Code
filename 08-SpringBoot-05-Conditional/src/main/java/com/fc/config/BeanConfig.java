package com.fc.config;

import com.fc.enetiy.GirlFriends;
import com.fc.enetiy.Son;
import com.fc.enetiy.Wife;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
//    @Bean("wife")
    public Wife getWife(){
        return new Wife();
    }
    @Bean("son")
    //满足条件时注入容器
    @ConditionalOnBean(Wife.class)
    public Son getSon(){
        return new Son();
    }


    @Bean("girlFriends")
    //没有此对象时注入容器
    @ConditionalOnMissingBean(Wife.class)
    public GirlFriends GirlFriends(){
        return new GirlFriends();
    }
}
