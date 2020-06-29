package com.nik.hibernate.demo;

import com.nik.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //query students
            List<Student> students = session.createQuery("from Student").getResultList();

            //display students
            displayStudents(students);

            //query students lastName: Wall
            students = session.createQuery("from Student s where s.lastName='Wall'").getResultList();

            //display students
            System.out.println("\n\nStudents who have last name Wall");
            displayStudents(students);

            //query students: lastName='Wall' OR firstName='Daffy'
            students =
                    session.createQuery("from Student s where"
                            + " s.lastName='Wall' OR s.firstName='Daffy'").getResultList();

            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            displayStudents(students);

            //query students where email LIKE '%gmail.com'
            students = session.createQuery("from Student s where"
                    + " s.email LIKE '%gmail.com'").getResultList();

            System.out.println("\n\nStudents whose email ends with gmail.com");
            displayStudents(students);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
