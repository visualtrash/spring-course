package com.nik.demoannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        //чтение spring com.nik.config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //получение бина из спринг контейнера
        Coach coach = context.getBean("golfCoach", Coach.class);

        //вызов метода бина
        System.out.println(coach.getDailyWorkout());

        //вызов метода для получения fortune
        System.out.println(coach.getDailyFortune());

        //закрытие контекста
        context.close();
    }
}
