package springdemo;

public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Passing the ball for 40 min";
    }
}
