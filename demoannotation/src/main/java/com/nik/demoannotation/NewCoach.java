package com.nik.demoannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class NewCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private RandomFortuneService randomFortuneService;


    public NewCoach() {
        System.out.println(">> newCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "just a newCoach";
    }

    @Override
    public String getDailyFortune() {
        return randomFortuneService.getFortune();
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getTeam() {
        return null;
    }
}
