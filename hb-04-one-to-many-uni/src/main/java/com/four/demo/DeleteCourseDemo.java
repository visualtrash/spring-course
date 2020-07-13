package com.four.demo;

import com.four.demo.entity.Course;
import com.four.demo.entity.Instructor;
import com.four.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //get course
            int id = 10;
            Course course = session.get(Course.class, id);

            //delete course
            System.out.println("Deleting course: " + course);

            session.delete(course);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();

            factory.close();
        }
    }
}
