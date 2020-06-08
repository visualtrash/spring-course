package com.nik.demoannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        //чтение spring config JAVA CLASS*
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

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
