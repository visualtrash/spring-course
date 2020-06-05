package com.nik.demoannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewCoach implements Coach {

    @Autowired
    @Qualifier("newFortuneService")
    private FortuneService fortuneService;


    public NewCoach() {
        System.out.println(">> newCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "just a newCoach";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
