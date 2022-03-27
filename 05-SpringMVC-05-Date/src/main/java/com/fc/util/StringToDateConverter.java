package com.fc.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //这是SpringMvc支持的格式
        String pattern = "yyyy/mm/dd";
        //如果请求字符串携带了-
        if(source.contains("-")){
            pattern = "yyyy-mm-dd";
        }
        //声明一个格式化器
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date parse = null;
        //字符串转为对应的日期对象
        try {
            parse = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


//    @Override
//    public Date convert(String source) {
//        //这是SpringMvc支持的格式
//        String pattern = "yyyy/mm/dd";
//        //如果请求字符串携带了-
//        if(source.contains("-")){
//            pattern = "yyyy-mm-dd";
//        }
//        //声明一个格式化器
//        SimpleDateFormat format = new SimpleDateFormat(pattern);
//        Date parse = null;
//        //字符串转为对应的日期对象
//        try {
//            parse = format.parse(source);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return parse;
//    }


//    @Override
//    public Date convert(String source) {
//        //这是SpringMvc支持的格式
//        String pattern = "yyyy/mm/dd";
//        //如果请求字符串中携带了-
//        if (source.contains("-")){
//            pattern = "yyyy-mm-dd";
//        }
//        //声明一个日期格式化器
//        SimpleDateFormat format = new SimpleDateFormat(pattern);
//        Date parse = null;
//        //字符串转为对应的日期对象
//        try {
//            parse = format.parse(source);
//        } catch (ParseException e) {
//
//        }
//        return parse;
//    }
}
