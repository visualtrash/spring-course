package nik.baseball;

public class TennisCoach implements Coach{
    private FortuneService fortuneService;

    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public TennisCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis. Not a penis";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
