package com.fc.advice;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomDateFormatter implements Formatter<Date> {
    String patten = "yyyy/mm/dd";
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        if(text.contains("-")){
            patten = "yyyy-mm-dd";
        }
        return new SimpleDateFormat(patten,locale).parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return new SimpleDateFormat(patten,locale).format(object);
    }
//    String patten = "yyyy/mm/dd";
//    @Override
//    public Date parse(String text, Locale locale) throws ParseException {
//        if(text.contains("-")){
//            patten = "yyyy-mm-dd";
//        }
//        return new SimpleDateFormat(patten,locale).parse(text);
//    }
//
//    @Override
//    public String print(Date object, Locale locale) {
//        return new SimpleDateFormat(patten,locale).format(object);
//    }
}
