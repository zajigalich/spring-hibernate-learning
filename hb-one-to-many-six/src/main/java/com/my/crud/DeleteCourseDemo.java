package com.my.crud;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try(sessionFactory; session) {

            session.beginTransaction();

            Course course = session.get(Course.class, 1L);

            session.delete(course);

            session.getTransaction().commit();
        }
    }
}
