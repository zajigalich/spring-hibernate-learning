package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = xmlApplicationContext.getBean("myCoach", Coach.class);

        //Coach newCoach =
        FootballCoach newCoach =
                xmlApplicationContext.getBean("newCoach", FootballCoach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.println(newCoach.getDailyWorkout());
        System.out.println(newCoach.getDailyFortune());
        System.out.println(newCoach.getEmail());
        System.out.println(newCoach.getTeam());



        xmlApplicationContext.close();

    }
}
