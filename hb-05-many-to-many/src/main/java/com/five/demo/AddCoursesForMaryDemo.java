package com.five.demo;

import com.five.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("ALL")
public class AddCoursesForMaryDemo {

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

            //get student
            int studentId = 5;
            Student student = session.get(Student.class, studentId);

            System.out.println("loaded student : " + student);
            System.out.println("courses : " + student.getCourses());

            //create more courses
            Course course1 = new Course("Rubik cube");
            Course course2 = new Course("PSP games");

            //add sudent to courses
            course1.addStudent(student);
            course2.addStudent(student);

            //save the courses
            System.out.println("saving courses... ");

            session.save(course1);
            session.save(course2);

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