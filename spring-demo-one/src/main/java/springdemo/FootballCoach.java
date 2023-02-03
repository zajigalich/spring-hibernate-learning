package springdemo;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;
    private String email;
    private String team;

    public FootballCoach() {
        System.out.println("FootballCoach: no-args constructor");
    }

    private void doStartup(){
        System.out.println("FootballCoach: init-method");
    }

    private void doFinishing(){
        System.out.println("FootballCoach: destroy-method");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("FootballCoach: fortuneService setter");
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

    public FortuneService getFortuneService() {
        return fortuneService;
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
