package com.nik.hibernate.demo;

import com.nik.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("Duplicates")
public class DeleteStudentDemo {

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

            //delete the student
//            System.out.println("Deleting student..." + student);
//            session.delete(student);

            //delete student id=2
            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
