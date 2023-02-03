package springdemo;

public class MyApp {
    public static void main(String[] args) {

        FortuneService fortuneService = new HappyFortuneService();

        Coach trackCoach = new TrackCoach(fortuneService);

        Coach baseballCoach = new BaseballCoach();

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());
    }
}
