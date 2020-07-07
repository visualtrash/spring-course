package com.one2one.hibernate.demo;

import com.one2one.hibernate.demo.entity.Instructor;
import com.one2one.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        //создание session factory
        SessionFactory factory = new Configuration()
                .configure("hb-01-one-to-one-uni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //создание session
        Session session = factory.getCurrentSession();

        try {

            //создание объектов
            Instructor instructor =
                    new Instructor("Vasya", "Rogov", "rog@code.com");

            InstructorDetail detail =
                    new InstructorDetail(
                            "http://www.nik.com/youtube",
                            "coding"
                    );

            //cвязать объекты
            instructor.setInstructorDetail(detail);

            //start transaction
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
