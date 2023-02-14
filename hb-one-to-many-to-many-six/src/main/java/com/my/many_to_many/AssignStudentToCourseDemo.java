package com.my.many_to_many;

import com.my.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AssignStudentToCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();



        try (session; sessionFactory) {
            session.beginTransaction();

            Long courseId = 7L;
            Long studentId = 2L;

            Course course = session.get(Course.class, courseId);

            course.add(session.get(Student.class, studentId));

            session.getTransaction().commit();
        }
    }
}
