package com.my.crud_uni;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import com.my.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviewDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Review review1 = new Review("Wow, amazing");
        Review review2 = new Review("Bad course");

        try(session; sessionFactory) {
            session.beginTransaction();

            Long courseId = 4L;

            Course course = session.get(Course.class, courseId);

            course.add(review1);
            course.add(review2);

            session.getTransaction().commit();

            System.out.println("review1 = " + review1);
            System.out.println("review2 = " + review2);

        }
    }
}
