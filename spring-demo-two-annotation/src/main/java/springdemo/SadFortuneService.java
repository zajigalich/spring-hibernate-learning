package springdemo;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your bad day!";
    }
}
