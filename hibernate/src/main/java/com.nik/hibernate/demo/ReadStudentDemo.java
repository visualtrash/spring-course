package com.nik.hibernate.demo;

import com.nik.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

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
            Student tempStudent = new Student("Daffy", "Duck", "dd@code.com");

            //start transaction
            session.beginTransaction();

            //сохранение объекта student
            System.out.println("Saving the student..");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            // NEW code

            //поиск Id студентов: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //получение новой session и старт transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //извлечение student по id: primary key
            System.out.println("\n Getting student with id: " + tempStudent.getId());

            Student student = session.get(Student.class, tempStudent.getId());

            System.out.println("Complete: " + student);

            //transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
