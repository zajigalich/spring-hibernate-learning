package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationBeanScopeLifecycleApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = applicationContext.getBean("tennisCoach", Coach.class);
        Coach coach1 = applicationContext.getBean("tennisCoach", Coach.class);

        System.out.println(coach == coach1);

        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyFortune());

        applicationContext.close();
    }
}
