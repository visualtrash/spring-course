package com.nik.demoannotation;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Sad day";
    }
}
