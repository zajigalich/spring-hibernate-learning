package com.my.crud;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        /*InstructorDetail instructorDetail =
                new InstructorDetail("my.youtube.com", "playing games");

        Instructor instructor =
                new Instructor("Tom", "Cat", "cat@gmail.com");*/

        InstructorDetail instructorDetail =
                new InstructorDetail("my.tube.com", "coding");

        Instructor instructor =
                new Instructor("Apache", "Maven", "maven@apache.us");

        instructor.setInstructorDetail(instructorDetail);

        //instructorDetail.setInstructor(instructor); //optional (we save instructor)

        try(sessionFactory; session) {

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
            System.out.println("instructorDetail = " + instructorDetail);
            System.out.println("instructor = " + instructor);
        }
    }
}
