package com.my.many_to_many;

import com.my.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Student student1 = new Student("Tomas", "Shelby", "peaky@gmail.com");
        //Student student2 = new Student("Magnus", "Carlsen", "champion@gmail.com");

        try (session; sessionFactory) {
            session.beginTransaction();

            Long courseId = 7L;

            Course course = session.get(Course.class, courseId);

            session.save(student1);
            //session.save(student2);

            course.add(student1);
            //course.add(student2);

            session.getTransaction().commit();
        }
    }
}
