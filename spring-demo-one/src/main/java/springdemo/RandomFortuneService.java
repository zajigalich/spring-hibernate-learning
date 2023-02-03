package springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] fortunes;
    private Random random;

    public RandomFortuneService(String fortunes) {
        random = new Random();
        this.fortunes = fortunes.split(", ");
    }

    @Override
    public String getFortune() {
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }
}
