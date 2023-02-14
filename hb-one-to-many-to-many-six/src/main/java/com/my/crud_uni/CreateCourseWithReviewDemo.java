package com.my.crud_uni;

import com.my.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseWithReviewDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();



        try(session; sessionFactory) {
            session.beginTransaction();

            Course course = new Course("Hibernate");

            course.add(new Review("Wow, amazing"));
            course.add(new Review("Bad course"));

            session.save(course);

            session.getTransaction().commit();

        }
    }
}
