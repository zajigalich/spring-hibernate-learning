package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeJavaConfigApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(PracticeSportConfig.class);

        Coach dotaCoach = applicationContext.getBean("dotaCoach", Coach.class);

        System.out.println(dotaCoach.getDailyWorkout());
        System.out.println(dotaCoach.getDailyFortune());

        applicationContext.close();
    }

}
