package com.nik.demoannotation;

import org.springframework.stereotype.Component;

@Component
public class NewFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "yoyo iam new";
    }
}
