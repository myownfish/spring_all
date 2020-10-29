package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theTrafficFortuneService = 
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String result = theTrafficFortuneService.getFortune();
        
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        System.out.println("\nMy fortuen is: " + result);
        
        System.out.println("Finished");
       
        context.close();
    }

}
