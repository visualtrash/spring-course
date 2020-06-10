package com.nik.demoannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        //чтение spring com.nik.config JAVA CLASS*
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //получение бина из спринг контейнера
        Coach coach = context.getBean("swimCoach", Coach.class);

        //вызов метода бина
        System.out.println(coach.getDailyWorkout());

        //вызов метода для получения fortune
        System.out.println(coach.getDailyFortune());

        //test values injected
        System.out.println("email: " + coach.getEmail());

        System.out.println("email: " + coach.getTeam());

        //закрытие контекста
        context.close();
    }
}
