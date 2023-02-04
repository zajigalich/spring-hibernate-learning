package springdemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your volley";
    }


    public String getFortune() {
        return "Practice your volley";
    }
}
