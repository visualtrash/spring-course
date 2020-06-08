package com.nik.demoannotation;

public class HungryFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Iam so hungry now!";
    }
}
