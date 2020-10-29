package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("Found instructor:" + instructor);

            if (instructor != null) {
                System.out.println("Deleting:" + instructor);

                session.delete(instructor);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

}
