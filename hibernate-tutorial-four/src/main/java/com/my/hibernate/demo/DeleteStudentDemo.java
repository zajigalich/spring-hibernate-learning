package com.my.hibernate.demo;

import com.my.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory; session){
            session.beginTransaction();

            Student student = session.get(Student.class, 3L);

            session.delete(student);

            /*session.getTransaction().commit();
            session = sessionFactory.getCurrentSession();*/

            session.createQuery("delete Student where id = 2").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
