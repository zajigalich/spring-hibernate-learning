package com.my.demo;

import com.my.entity.Course;
import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateCoursesDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Course course1 = new Course("Spring");
        Course course2 = new Course("Hibernate");

        try(sessionFactory; session) {

            session.beginTransaction();

            /*Course course = session.get(Course.class, 2L);
            course.setInstructor(session.get(Instructor.class, 1L));*/

            Instructor instructor = session.get(Instructor.class, 1L);

            instructor.add(course1);
            instructor.add(course2);

            /*course1.setInstructor(instructor);
            course2.setInstructor(instructor);*/ //in this scenario optional

            session.save(course1);
            session.save(course2);

            System.out.println("instructor = " + instructor);
            System.out.println("instructorCourses = " + instructor.getCourses());

            session.getTransaction().commit();
        }
    }
}
