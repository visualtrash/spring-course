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

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getTeam() {
        return null;
    }
}
