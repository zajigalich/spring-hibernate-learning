package com.my.crud_uni;

import com.my.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class GetCourseWithReview {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try (session; sessionFactory) {
            session.beginTransaction();

            Long courseId = 4L;

            Query<Course> query = session.createQuery("select c from Course c join fetch c.reviews where c.id = :course_id", Course.class);

            query.setParameter("course_id", courseId);

            Course course = query.getSingleResult();

            session.getTransaction().commit();

            System.out.println("course = " + course);
            System.out.println("reviews :" + course.getReviews());
        }
    }
}
