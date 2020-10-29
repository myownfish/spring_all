package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootballCoach implements Coach{

    private FortuneService service;
    
    public FootballCoach() {
        System.out.println("In FootballCoach constructor!");
    }

    public FortuneService getService() {
        return service;
    }

//    @Autowired
//    @Qualifier("happyFortuneService")
//    public void setService(FortuneService service) {
//        System.out.println("in setService method");
//        this.service = service;
//    }
    
    @Autowired
    @Qualifier("randomFortune")
    public void doSomeCrazyStuff(FortuneService service) {
        System.out.println("In doSomeCrazyStuff method");
        this.service = service;
    }

    public String getDailyWorkout() {
        return "Keep practise foolball for 1 hour.";
    }

    public String getDailyFortune() {
        return service.getFortune();
    }

}
