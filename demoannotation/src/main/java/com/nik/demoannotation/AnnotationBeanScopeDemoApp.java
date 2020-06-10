package com.nik.demoannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        //загрузка spring com.nik.config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //получение бина из спринг контейнера
        Coach coach = context.getBean("newCoach", Coach.class);

        Coach alphaCoach = context.getBean("newCoach", Coach.class);

        //проверка, одинаковы ли?
        boolean result = (coach == alphaCoach);

        System.out.println("\n Ponting to the same object: " + result);

        System.out.println("\n Memory location for the coach: " + coach);

        System.out.println("\n Memory location for the a-coach: " + alphaCoach);


        //close context
        context.close();
    }
}
