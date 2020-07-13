package com.lazy.demo;

import com.lazy.demo.entity.Course;
import com.lazy.demo.entity.Instructor;
import com.lazy.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {

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

            System.out.println("nik2code Instructor: " + instructor);

            // get course for the instructor
            System.out.println("nik2code: Courses: " + instructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            //close session
            session.close();

            System.out.println("\n nik2code: session close");
            //fail

            // get course for the instructor
            System.out.println("nik2code: Courses: " + instructor.getCourses());

            System.out.println("nik2code: Done!");
        } finally {
            session.close();

            factory.close();
        }
    }
}
