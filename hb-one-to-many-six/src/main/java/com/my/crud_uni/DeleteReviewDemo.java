package com.my.crud_uni;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import com.my.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteReviewDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try(session; sessionFactory) {
            session.beginTransaction();

            Long reviewId = 1L;

            Review review = session.get(Review.class, reviewId);

            System.out.println("deleting " + review);

            session.delete(review);

            session.getTransaction().commit();

        }
    }
}
