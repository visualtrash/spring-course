package nik.baseball;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        //загрузка файла спринг-конфигурации
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //извлечение бина из спринг-контейнера
        Coach coach = context.getBean("myCoach", Coach.class);

        //вызов методов бина
        System.out.println(coach.getDailyWorkout());

        //вызов новых методов для fortunes
        System.out.println(coach.getDailyFortune());

        //закрытие контекста
        context.close();
    }
}
