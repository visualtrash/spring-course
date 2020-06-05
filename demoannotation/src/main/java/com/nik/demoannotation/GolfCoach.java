package com.nik.demoannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public GolfCoach() {
        System.out.println(">> GolfCoach: inside default constructor");
    }

    //setter
//    @Autowired
//    public void yoyo(FortuneService fortuneService) {
//        System.out.println(">> GolfCoach: inside default yoyo");
//        this.fortuneService = fortuneService;
//    }

    //    @Autowired
//    public GolfCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    public String getDailyWorkout() {
        return "Practice in rich game";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
