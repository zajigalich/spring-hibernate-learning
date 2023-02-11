package com.my.hibernate.demo;

import com.my.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Student student = session.get(Student.class, 3L);
            student.setFirstName("Tomcat");

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student s set s.email = 'garr@gmail.com' where s.firstName like 'garry%' ")
                    .executeUpdate();

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }


    }
}
