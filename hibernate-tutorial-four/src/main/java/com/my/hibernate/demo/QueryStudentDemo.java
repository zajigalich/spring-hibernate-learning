package com.my.hibernate.demo;

import com.my.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Student student1 = new Student("Bonita", "Stick", "bonita@gmail.com");
        Student student2 = new Student("Garry", "Potter", "garry@gmail.com");
        Student student3 = new Student("Tom", "Dic", "tom@mail.ua");

        Session session = sessionFactory.getCurrentSession();

        try {

            /*session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();*/

            session.beginTransaction();
            System.out.println("\nAll students:");
            List<Student> studentList = session.createQuery("from Student").getResultList();
            studentList.forEach(System.out::println);

            System.out.println("\nStudents which email ends with gmail.com:");
            studentList = session.createQuery("from Student s " +
                    "where s.email like '%gmail.com'").getResultList();
            studentList.forEach(System.out::println);

            System.out.println("\nStudents which email ends with luv2code.com:");
            studentList = session.createQuery("from Student s " +
                    "where s.email like '%luv2code.com'").getResultList();
            studentList.forEach(System.out::println);

            System.out.println("\nStudents with lastname Stick:");
            studentList = session.createQuery("from Student s " +
                    "where s.lastName = 'Stick'").getResultList();
            studentList.forEach(System.out::println);

            System.out.println("\nStudents with lastname potter or firstname starts with T:");
            studentList = session.createQuery("from Student s " +
                    "where s.lastName = 'Potter'" +
                    "or s.firstName like 'T%'").getResultList();
            studentList.forEach(System.out::println);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
