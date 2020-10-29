package com.luv2code.springboot.demo.springbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFunController {

    @GetMapping("/")
    public String mainPage() {
        return "Hello World " + LocalDateTime.now();
    }
}
