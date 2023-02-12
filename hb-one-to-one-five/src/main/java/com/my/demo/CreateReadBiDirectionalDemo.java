package com.my.demo;

import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReadBiDirectionalDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        /*Instructor instructor =
                new Instructor("Tom", "Cat");

        InstructorDetail instructorDetail =
                new InstructorDetail("my.youtube.com", "playing games");

        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetail(instructorDetail);*/ //create bi-directional

        try(sessionFactory; session) {

            session.beginTransaction();

            //session.save(instructorDetail);

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2L);
            Instructor instructor = instructorDetail.getInstructor();

            session.getTransaction().commit();
            System.out.println("instructor = " + instructor);
            System.out.println("instructorDetail = " + instructorDetail);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
