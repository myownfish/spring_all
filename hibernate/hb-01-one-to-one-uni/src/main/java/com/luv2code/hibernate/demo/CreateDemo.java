package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

    public static void main(String[] args) {
     
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor = new Instructor("Chad", "Darby", "draby@luv2code.com");
            InstructorDetail tempInstructorDetail = 
                    new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!");
            
            Instructor tempInstructor1 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail1 = 
                    new InstructorDetail("http://www.youtube.com", "Guitar");
            
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            tempInstructor1.setInstructorDetail(tempInstructorDetail1);

            session.beginTransaction();
            
            session.save(tempInstructor);
            session.save(tempInstructor1);


            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

}
