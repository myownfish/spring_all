package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {

    @Value("${arrayOfFortune}")
    private String[] fortunes;
    Random random = new Random();

    
    public String getFortune() {
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }

}
