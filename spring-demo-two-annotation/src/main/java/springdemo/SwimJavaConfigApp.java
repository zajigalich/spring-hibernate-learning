package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Coach swimCoach = applicationContext.getBean("swimCoach", Coach.class);

        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println(swimCoach.getTeam());

        applicationContext.close();
    }
}
