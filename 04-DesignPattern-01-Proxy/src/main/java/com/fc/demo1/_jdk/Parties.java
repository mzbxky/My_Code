package com.fc.demo1._jdk;

public class Parties implements Lawsuit {
    @Override
    public void submit() {
        System.out.println("带着小姨子跑路");
    }

    @Override
    public void defend() {
        System.out.println("还我血汗钱");
    }
}
