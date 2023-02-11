package com.my.hibernate.practice;

import com.my.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try(session; sessionFactory) {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1L);
            employee.setFirstName("Scooby");


            session.createQuery("update Employee set company = 'Bethesda'").executeUpdate();


            session.createQuery("update Employee set lastName = 'Dumb' where firstName like 'G%'").executeUpdate();


            session.getTransaction().commit();
        }

    }
}
