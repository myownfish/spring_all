package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            
            int theId = 47;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail:" + tempInstructorDetail);
            
            System.out.println("the associated Instructor: " + tempInstructorDetail.getInstructor());

            session.getTransaction().commit();
        } catch(Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

}
