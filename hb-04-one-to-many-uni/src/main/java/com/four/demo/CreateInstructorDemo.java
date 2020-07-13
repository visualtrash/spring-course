package com.four.demo;

import com.four.demo.entity.Course;
import com.four.demo.entity.Instructor;
import com.four.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

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

            //создание объектов
            Instructor instructor =
                    new Instructor("Sweet", "Bubalech", "bubalech@code.com");

            InstructorDetail detail =
                    new InstructorDetail(
                            "http://www.youtube.com/s.bubalech",
                            "films"
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
            session.close();

            factory.close();
        }
    }
}
