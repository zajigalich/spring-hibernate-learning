package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeLifeCycleSpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beanScopeLifeCicle-applicationContext.xml");

        FootballCoach coach = applicationContext.getBean("myCoach", FootballCoach.class);
        FootballCoach coach1 = applicationContext.getBean("myCoach", FootballCoach.class);

        FortuneService fortuneService = applicationContext.getBean("myFortune", FortuneService.class);
        FortuneService fortuneService1 = applicationContext.getBean("myFortune", FortuneService.class);

        System.out.println(coach == coach1);
        System.out.println(coach.getFortuneService() == coach1.getFortuneService());

        System.out.println(fortuneService1 == fortuneService);

        applicationContext.close();

        System.out.println(coach.getFortuneService().getFortune());

    }
}
