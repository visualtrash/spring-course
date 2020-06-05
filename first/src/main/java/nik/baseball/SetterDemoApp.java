package nik.baseball;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {

        //загрузка спринг-конфигурации файла
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //извлечение бина из спринг-контейнера
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);

        //вызов методов бина
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());


        //вызов новых методов для получения знечений полей
        System.out.println(coach.getEmailAddress());

        System.out.println(coach.getTeam());

        //закрытие контекста
        context.close();
    }
}
