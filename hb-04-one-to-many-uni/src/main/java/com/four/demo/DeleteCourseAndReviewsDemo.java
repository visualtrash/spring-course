package com.four.demo;

import com.four.demo.entity.Course;
import com.four.demo.entity.Instructor;
import com.four.demo.entity.InstructorDetail;
import com.four.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviewsDemo {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //get course
            int id = 10;
            Course course = session.get(Course.class, id);

            //print course
            System.out.println("deleting" + course);

            //print review
            System.out.println(course.getReviews());

            //delete
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
