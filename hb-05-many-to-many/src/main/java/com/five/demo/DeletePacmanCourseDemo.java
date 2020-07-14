package com.five.demo;

import com.five.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("ALL")
public class DeletePacmanCourseDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            //get pacman course
            int courseId = 13;

            Course course = session.get(Course.class, courseId);

            //delete course
            System.out.println("Deleting course...");

            session.delete(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}