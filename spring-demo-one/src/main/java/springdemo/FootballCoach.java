package springdemo;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;
    private String email;
    private String team;

    public FootballCoach() {
        System.out.println("TheCoach(Football)");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TheCoach FortuneService setter");
        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        System.out.println("TheCoach email setter");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println("TheCoach team setter");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Passing the ball for 40 min";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
