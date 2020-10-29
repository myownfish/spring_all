package kitty.demo.spring;

import org.springframework.stereotype.Service;

@Service("unhappyFortuneService")
public class UnhappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is a bad day!";
    }

}
