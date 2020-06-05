package nik.baseball;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {

        //загрузка файла спринг-конфигурации
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        //извлечение бина из спринг-контейнера
        Coach coach = context.getBean("myCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());

        //закрытие контекста
        context.close();
    }
}
