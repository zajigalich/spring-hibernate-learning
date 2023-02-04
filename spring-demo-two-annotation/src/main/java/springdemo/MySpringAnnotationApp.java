package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringAnnotationApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach = applicationContext.getBean("tennisCoach", Coach.class);
        Coach dotaCoach = applicationContext.getBean("dotaCoach", Coach.class);

        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(dotaCoach.getDailyWorkout());

        applicationContext.close();
    }
}
