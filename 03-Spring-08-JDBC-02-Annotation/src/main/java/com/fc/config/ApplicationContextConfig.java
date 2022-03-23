package com.fc.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

////将指定路径下的配置文件加载进来
//@PropertySource("classPath:jdbc.properties")
//@ComponentScan("com.fc")
////声明了此注解说明当前类是配置类
//@Configuration

////将指定路径下的配置文件加载进来
//@PropertySource("classPath:jdbc.properties")
//@ComponentScan("com.fc")
//@Configuration
////声明了此注解说明当前是配置类

//将指定路径下的配置文件加载进来
@PropertySource("classPath:jdbc.properties")
@ComponentScan("com.fc")
@Configuration
//声明了此注解说明当前类是配置类
public class ApplicationContextConfig {
    @Value("jdbc.Driver")
    private String driverClassName;
    @Value("jdbc.url")
    private String url;
    @Value("jdbc.username")
    private String username;
    @Value("jdbc.password")
    private String password;
    @Bean
    //声明Bean注解用于将当前方法的返回值放到容器中
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = null;
        try {
        Properties properties = new Properties();
        properties.setProperty("driverClassName",driverClassName);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("password",password);
        DataSource dataSource;

        dataSource = DruidDataSourceFactory.createDataSource(properties);
        jdbcTemplate = new JdbcTemplate(dataSource);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  jdbcTemplate;
    }
//    @Value("jdbc.Driver")
//    private String driverClassName;
//    @Value("jdbc.url")
//    private String url;
//    @Value("jdbc.username")
//    private String username;
//    @Value("jdbc.password")
//    private String password;
//    //用bean注解用于将当前方法的返回值放到容器中
//    @Bean
//    public JdbcTemplate getJdbcTemplate(){
//        JdbcTemplate jdbcTemplate = null;
//        try {
//        Properties properties = new Properties();
//        properties.setProperty("driverClassName",driverClassName);
//        properties.setProperty("url",url);
//        properties.setProperty("username",username);
//        properties.setProperty("password",password);
//        DataSource dataSource;
//
//        dataSource = DruidDataSourceFactory.createDataSource(properties);
//        jdbcTemplate = new JdbcTemplate(dataSource);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jdbcTemplate;
//    }
//    @Value("jdbc.Driver")
//    private String driverClassName;
//    @Value("jdbc.url")
//    private String url;
//    @Value("jdbc.username")
//    private String username;
//    @Value("jdbc.password")
//    private String password;
//    //用bean注解用于将当前方法的返回值放到容器中
//    @Bean("jdbc.Driver")
//    public JdbcTemplate getJdbcTemplate(){
//
//        JdbcTemplate jdbcTemplate = null;
//        try {
//            Properties properties = new Properties();
//            properties.setProperty("driverClassName",driverClassName);
//            properties.setProperty("url",url);
//            properties.setProperty("username",username);
//            properties.setProperty("password",password);
//            DataSource dataSource;
//            dataSource = DruidDataSourceFactory.createDataSource(properties);
//            jdbcTemplate = new JdbcTemplate(dataSource);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jdbcTemplate;
//    }


//    @Value("${jdbc.driver}")
//    private String driverClassName;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;
//    // @Bean注解用于将当前方法的返回值放到容器中
//    @Bean("jdbcTemplate")
//    public JdbcTemplate getJdbcTemplate() {
//        JdbcTemplate jdbcTemplate = null;
//
//        try {
//            Properties properties = new Properties();
//
//            properties.setProperty("driverClassName", driverClassName);
//            properties.setProperty("url", url);
//            properties.setProperty("username", username);
//            properties.setProperty("password", password);
//
//            DataSource dataSource;
//
//            dataSource = DruidDataSourceFactory.createDataSource(properties);
//
//            jdbcTemplate = new JdbcTemplate(dataSource);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jdbcTemplate;
//    }
}
