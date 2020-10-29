package kitty.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
public class TennisCoach implements Coach {
    
    @Autowired
    private FortuneService service;

    @Override
    public String getDailyWorkout() {
        return "Play tennis for 30 mins";
    }

    @Override
    public String getDailyFortune() {
        return service.getFortune();
    }

}
