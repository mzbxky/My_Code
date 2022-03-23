package com.fc.demo1._static;

import org.junit.Test;

public class Court {
//    @Test
//    //原告击鼓鸣冤
//    public void test(){
//        Lawsuit parties = new Parties();
//        Lawsuit lawyer = new Lawyer(parties);
//        lawyer.submit();
//        lawyer.defend();
//
//    }
//    @Test
//    public void test(){
//        Lawsuit parties = new Parties();
//        Lawsuit lawyer = new Lawyer(parties);
//        lawyer.submit();
//        lawyer.defend();
//    }
    @Test
    public void test(){
        Lawsuit parties = new Parties();
        Lawsuit lawyer = new Lawyer(parties);
        lawyer.submit();
        lawyer.defend();
    }
}
