package com.my.lazy_eager;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class GetCoursesLater {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {

            Long instructorId = 1L;

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, instructorId);
            System.out.println(instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println("\nConnection recreated\n");

            //next part can occur later

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Query<Course> query = session.createQuery("select c from Course c where c.instructor.id = :instructorId", Course.class);

            query.setParameter("instructorId", instructorId);

            List<Course> courses = query.getResultList();

            session.getTransaction().commit();

            System.out.println("courses = " + courses);

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
