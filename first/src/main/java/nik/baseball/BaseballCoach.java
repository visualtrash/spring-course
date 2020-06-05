package nik.baseball;

public class BaseballCoach implements Coach {

    // объявление приватного поля для зависимости
    private FortuneService fortuneService;

    //объявление конструктора для внедрение зависимости
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 min on practice";
    }

    @Override
    public String getDailyFortune() {

        //использую fortuneService для получения fortune
        return fortuneService.getFortune();
    }
}
