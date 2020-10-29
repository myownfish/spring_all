package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            int theId = 6;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail:" + tempInstructorDetail);

            System.out.println("the associated Instructor: " + tempInstructorDetail.getInstructor());

            System.out.println("Deleting tempInstructorDetail:" + tempInstructorDetail);

            /*
             * This is to resolve:
             * javax.persistence.EntityNotFoundException: deleted object would be re-saved
             * by cascade (remove deleted object from associations):
             * [com.luv2code.hibernate.demo.entity.InstructorDetail#6]
             * 
             */
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
