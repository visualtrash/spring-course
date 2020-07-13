package com.four.demo;

import com.four.demo.entity.Course;
import com.four.demo.entity.Instructor;
import com.four.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

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

            //**get instructor from db
            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            //create some courses
            Course course1 = new Course("Guitar lessons");
            Course course2 = new Course("Pinball masterclass");

            //add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            //save the courses
            session.save(course1);
            session.save(course2);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();

            factory.close();
        }
    }
}
