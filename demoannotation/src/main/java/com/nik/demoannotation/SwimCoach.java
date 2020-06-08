package com.nik.demoannotation;


import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1 km as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
