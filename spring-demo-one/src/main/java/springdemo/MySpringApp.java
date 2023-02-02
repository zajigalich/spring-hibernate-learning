package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = xmlApplicationContext.getBean("myCoach", Coach.class);

        Coach newCoach = xmlApplicationContext.getBean("newCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(newCoach.getDailyWorkout());

        xmlApplicationContext.close();


    }
}
