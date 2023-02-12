package com.my.demo;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try(sessionFactory; session) {

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1L);

            System.out.println("instructor = " + instructor);

            System.out.println("Courses: " + instructor.getCourses());

            session.getTransaction().commit();
        }
    }
}
