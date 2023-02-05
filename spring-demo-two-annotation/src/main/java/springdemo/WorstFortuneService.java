package springdemo;

public class WorstFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "All your today`s teammates will be dumb";
    }
}
