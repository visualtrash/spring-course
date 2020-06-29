package com.nik.hibernate.demo;

import com.nik.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

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

            //создание объекта student
            System.out.println("creating new Student obj ...");
            Student tempStudent = new Student("Oleg", "Oslov", "oselne@code.com");

            //start transaction
            session.beginTransaction();

            //сохранение объекта student
            System.out.println("Saving the student..");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
