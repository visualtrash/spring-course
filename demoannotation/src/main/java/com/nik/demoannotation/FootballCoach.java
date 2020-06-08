package com.nik.demoannotation;

import org.springframework.beans.factory.annotation.Value;


public class FootballCoach implements Coach {
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Iam a gay";
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
