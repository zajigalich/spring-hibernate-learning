package springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("springdemo")
@PropertySources({
        @PropertySource("classpath:sport.properties"),
        @PropertySource("classpath:logger.properties")
})
public class SportConfig {

    @Bean
    public MyJavaLoggerConfig myJavaLoggerConfig(
            @Value("${root.logger}") String rootLoggerLevel,
            @Value("${printed.logger}") String printedLoggerLevel
    ) {
        return new MyJavaLoggerConfig(rootLoggerLevel, printedLoggerLevel);
    }

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
