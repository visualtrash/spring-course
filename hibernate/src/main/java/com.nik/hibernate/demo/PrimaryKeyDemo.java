package com.nik.hibernate.demo;

import com.nik.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {
            //использование объекта session для сохранения в java объект

            //создание 3 объекта student
            System.out.println("creating 3 Student obj ...");
            Student tempStudent1 = new Student("Alex", "Smirnov", "smirnov@code.com");
            Student tempStudent2 = new Student("John", "Wall", "wall@code.com");
            Student tempStudent3 = new Student("Leo", "Sex", "leo@code.com");

            //start transaction
            session.beginTransaction();

            //сохранение объекта student
            System.out.println("Saving the students..");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
