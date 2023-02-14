package com.my.many_to_many;

import com.my.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RemoveStudentFromCourseDemo {
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

            Long studentId = 2L;
            Long courseId = 7L;

            Course course = session.get(Course.class, courseId);

            Student student = session.get(Student.class, studentId);

            student.remove(course);

            session.getTransaction().commit();
        }
    }
}
