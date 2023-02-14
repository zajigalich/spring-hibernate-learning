package com.my.lazy_eager;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinFetchDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try (sessionFactory; session) {

            session.beginTransaction();

            Long id = 1L;

            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id = :instructorId",
                    Instructor.class);

            query.setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            session.getTransaction().commit();

            System.out.println(instructor);
            System.out.println(instructor.getCourses());

        }
    }
}
