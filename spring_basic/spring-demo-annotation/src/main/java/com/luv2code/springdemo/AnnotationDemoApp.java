package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach = context.getBean("thatSillyCoach", Coach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
//        
//        Coach footballCoach = context.getBean("footballCoach", Coach.class);
//        System.out.println(footballCoach.getDailyWorkout());
//        System.out.println(footballCoach.getDailyFortune());
        
        context.close();
    }

}
