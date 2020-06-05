package com.nik.demoannotation;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] array = {
            "one",
            "two",
            "three"
    };

    private Random random = new Random();

    public String getFortune() {
        int index = random.nextInt(array.length);

        String fortune = array[index];
        return fortune;
    }
}
