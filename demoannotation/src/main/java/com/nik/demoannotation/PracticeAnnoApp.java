package com.nik.demoannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnoApp {
    public static void main(String[] args) {

        // чтение spring com.nik.config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // получение бина из спринг-контейнера
        Coach theCoach = context.getBean("newCoach", Coach.class);

        // вызов метода бина
        System.out.println(theCoach.getDailyWorkout());

        // вызов метода бина
        System.out.println(theCoach.getDailyFortune());

        // закрытие контекста
        context.close();
    }
}
