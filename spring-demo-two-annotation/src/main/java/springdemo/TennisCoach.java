package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    /*@Autowired
    @Qualifier("randomFortuneService")*/
    private FortuneService fortuneService;

    @Value("${foo.team}")
    private String team;

    public TennisCoach() {
        System.out.println("TennisCoach: no-arg constructor");
    }

    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        System.out.println("TennisCoach: fortuneService constructor");
        this.fortuneService = fortuneService;
    }

    /*@Autowired
    @Qualifier("randomFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TennisCoach: fortuneService DI via setter");
        this.fortuneService = fortuneService;
    }*/

    /*
    @Autowired
    public void doSomeStuff(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        System.out.println("TennisCoach: fortuneService DI via method");
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getTeam() {
        return team;
    }
}
