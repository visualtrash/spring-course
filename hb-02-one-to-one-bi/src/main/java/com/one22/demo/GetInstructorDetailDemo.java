package com.one22.demo;

import com.one22.demo.entity.Instructor;
import com.one22.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailDemo {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //**get instructor detail obj
            int id = 2332;

            InstructorDetail instructorDetail =
                    session.get(InstructorDetail.class, id);

            //**print instructor detail
            System.out.println("instructorDetail: " + instructorDetail);

            //**print associated instructor
            System.out.println("associated instructor: " +
                    instructorDetail.getInstructor());

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close session
            session.close();

            factory.close();
        }
    }
}
