package com.my.many_to_many;

import com.my.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class GetCourseWithStudentDemo {
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

            Query<Course> query = session.createQuery("select c from Course c join fetch c.students where c.id = 7", Course.class);

            Course course = query.getSingleResult();

            session.getTransaction().commit();

            System.out.println(course.getStudents());
        }
    }
}
