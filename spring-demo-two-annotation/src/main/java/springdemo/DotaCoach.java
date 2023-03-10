package springdemo;

public class DotaCoach implements Coach {

    private FortuneService fortuneService;

    public DotaCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Play 20 games in pomoyka";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getTeam() {
        return null;
    }
}
