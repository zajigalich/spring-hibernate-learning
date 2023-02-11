package com.my.hibernate.practice;

import com.my.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Employee employee1 = new Employee("Tomcat", "Dic", "Apache");
        Employee employee2 = new Employee("Bonita", "Stick", "Google");
        Employee employee3 = new Employee("Garry", "Potter", "Hogwarts");

        Session session = sessionFactory.getCurrentSession();

        try(session; sessionFactory) {
            session.beginTransaction();

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            session.getTransaction().commit();
        }

    }
}
