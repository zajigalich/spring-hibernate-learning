package com.my.crud_bi;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import com.my.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try(sessionFactory; session) {

            session.beginTransaction();

            Course course = session.get(Course.class, 4L);

            session.delete(course);

            session.getTransaction().commit();
        }
    }
}
