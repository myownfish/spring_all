package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class UNhappyForturnService implements FortuneService {

    public String getFortune() {
        return "Today is a bad day!";
    }

}
