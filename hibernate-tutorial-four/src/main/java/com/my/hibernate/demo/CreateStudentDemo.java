package com.my.hibernate.demo;

import com.my.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure() //configure(hibernate.cfg.xml)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // truncate hb_student_tracker.student to recreate(reset) table

        // alter table hb_student_tracker.student auto_increment = 1 to changing starting index

        Student student1 = new Student("Bonita", "Stick", "bonita@gmail.com");
        Student student2 = new Student("Garry", "Potter", "garry@gmail.com");
        Student student3 = new Student("Tom", "Dic", "tom42k@gmail.com");

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
