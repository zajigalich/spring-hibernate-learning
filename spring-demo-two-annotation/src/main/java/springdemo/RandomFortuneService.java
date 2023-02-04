package springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope("singleton")
public class RandomFortuneService implements FortuneService {

/*    @Value("${foo.fortunes}")
    private String fortunes;*/

    private List<String> fortunes;
    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(fortunes.size());
        return fortunes.get(index);
    }

    @PostConstruct
    private void readFortunesFromFile() {

        System.out.println("RandomFortuneService: init method called");

        fortunes = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("spring-demo-two-annotation/src/main/resources/fortunes.txt"))){

            String tmp;
            while ((tmp = bufferedReader.readLine()) != null){
                fortunes.add(tmp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
