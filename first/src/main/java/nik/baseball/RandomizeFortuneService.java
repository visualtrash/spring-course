package nik.baseball;

import java.util.Random;

public class RandomizeFortuneService implements FortuneService{

    private String[] array = {
            "one",
            "two",
            "three"
    };

    //рандомайзер
    private Random myRandom = new Random();


    @Override
    public String getFortune() {
        //получение рандомных значений из массива (array)
        int index = myRandom.nextInt(array.length);

        return array[index];
    }
}
