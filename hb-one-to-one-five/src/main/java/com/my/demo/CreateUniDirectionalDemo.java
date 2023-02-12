package com.my.demo;

import com.my.entity.InstructorDetail;
import com.my.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUniDirectionalDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        InstructorDetail instructorDetail =
                new InstructorDetail("my.youtube.com", "playing games");

        Instructor instructor =
                new Instructor("Tom", "Cat");

        /*InstructorDetail instructorDetail =
                new InstructorDetail("my.tube.com", "coding");

        Instructor instructor =
                new Instructor("Apache", "Maven");*/

        instructor.setInstructorDetail(instructorDetail);

        try(sessionFactory; session) {

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
            System.out.println("instructorDetail = " + instructorDetail);
            System.out.println("instructor = " + instructor);
        }
    }
}
