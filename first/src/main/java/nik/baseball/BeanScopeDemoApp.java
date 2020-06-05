package nik.baseball;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        //загрузка файла спринг-конфигурации
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //извлечение бина из спринг-контейнера
        Coach coach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        //проверка, являются ли они одинаковыми
        boolean result = (coach == alphaCoach);

        //вывод результата
        System.out.println("\n Pointing to the same object: " + result);

        System.out.println("\n Memory location for the coach: " + coach);

        System.out.println("\n Memory location for the coach: " + alphaCoach + "\n");

        //закрытие контекста
        context.close();
    }
}
