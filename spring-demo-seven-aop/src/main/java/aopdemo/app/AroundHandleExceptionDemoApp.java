package aopdemo.app;

import aopdemo.config.JavaAOPConfig;
import aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundHandleExceptionDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaAOPConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("MainApp:\n");

        boolean tripWire = true;
        String fortune = fortuneService.getFortune(tripWire);

        System.out.println(fortune);

        System.out.println("\nFinished");
        context.close();
    }
}

