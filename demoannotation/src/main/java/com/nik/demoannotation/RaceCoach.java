package com.nik.demoannotation;

import org.springframework.stereotype.Component;

@Component
public class RaceCoach implements Coach {
    public String getDailyWorkout() {
        return "wroom! about half-day";
    }

    public String getDailyFortune() {
        return null;
    }
}
