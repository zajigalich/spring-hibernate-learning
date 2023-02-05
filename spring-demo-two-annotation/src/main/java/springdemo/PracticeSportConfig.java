package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {

    @Bean
    public FortuneService worstFortuneService(){
        return new WorstFortuneService();
    }

    @Bean
    public Coach dotaCoach(){
        return new DotaCoach(worstFortuneService());
    }
}
