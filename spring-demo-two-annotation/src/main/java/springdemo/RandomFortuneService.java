package springdemo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

/*    @Value("${foo.fortunes}")
    private String fortunes;*/

    private Random random = new Random();

    @Override
    public String getFortune() {
        List<String> fortunes = readFortunesFromFile();

        int index = random.nextInt(fortunes.size());
        return fortunes.get(index);
    }

    private List<String> readFortunesFromFile() {

        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("spring-demo-two-annotation/src/main/resources/fortunes.txt"))){

            String tmp;
            while ((tmp = bufferedReader.readLine()) != null){
                lines.add(tmp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
