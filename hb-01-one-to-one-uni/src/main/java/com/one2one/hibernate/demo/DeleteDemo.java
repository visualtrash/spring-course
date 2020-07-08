package com.one2one.hibernate.demo;

import com.one2one.hibernate.demo.entity.Instructor;
import com.one2one.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

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

            //get instructor by primary key\id
            int id = 1;
            Instructor instructor =
                    session.get(Instructor.class, id);

            System.out.println("found instructor: " + instructor);

            //**delete the instructor
            if (instructor != null) {
                System.out.println("deleting the instructor..: " + instructor);

                session.delete(instructor);
            }

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
