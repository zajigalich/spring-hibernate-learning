package springdemo;

import org.springframework.stereotype.Component;

//@Component
public class DotaCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Play 20 games in pomoyka";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    @Override
    public String getTeam() {
        return null;
    }
}
