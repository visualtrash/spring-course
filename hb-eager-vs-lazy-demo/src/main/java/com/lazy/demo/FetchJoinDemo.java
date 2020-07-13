package com.lazy.demo;

import com.lazy.demo.entity.Course;
import com.lazy.demo.entity.Instructor;
import com.lazy.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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

            //get instructor from db
            int id = 1;

            //**Hibernate query with HQL
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courses "
                                    + "where i.id=:instructorId",
                            Instructor.class);

            //set query param
            query.setParameter("instructorId", id);

            //execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("nik2code Instructor: " + instructor);

            //commit transaction
            session.getTransaction().commit();

            //close session
            session.close();

            System.out.println("\nnik2code: session close");

            // get course for the instructor
            System.out.println("nik2code: Courses: " + instructor.getCourses());

            System.out.println("nik2code: Done!");
        } finally {
            session.close();

            factory.close();
        }
    }
}
