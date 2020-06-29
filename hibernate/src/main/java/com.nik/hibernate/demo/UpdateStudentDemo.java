package com.nik.hibernate.demo;

import com.nik.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            //получение новой session и старт transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //извлечение student по id: primary key
            System.out.println("\n Getting student with id: " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            student.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();

            //new code

            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
