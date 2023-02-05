package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Coach coach = applicationContext.getBean("tennisCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getTeam());

        applicationContext.close();
    }
}
