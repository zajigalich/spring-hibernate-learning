package com.my.hibernate.demo;

import com.my.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Student student = new Student("Bonita", "Stick", "bonita@gmail.com");

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("student = " + student);

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();


            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            Student myStudent = session.get(Student.class, student.getId());
            session.getTransaction().commit();

            System.out.println("myStudent = " + myStudent);

        } finally {
            session.close();
            sessionFactory.close();
        }


    }
}
