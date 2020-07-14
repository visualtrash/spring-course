package com.five.demo;

import com.five.demo.entity.Course;
import com.five.demo.entity.Instructor;
import com.five.demo.entity.InstructorDetail;
import com.five.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {

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

            //create course
            Course course = new Course("Pacman speedrun");

            //add reviews
            course.addReview(new Review("nice! and fast!"));
            course.addReview(new Review("worth it!"));
            course.addReview(new Review("not bad"));

            //save course
            System.out.println("saving course" + course);
            System.out.println(course.getReviews());

            session.save(course);

            //commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();

            factory.close();
        }
    }
}
