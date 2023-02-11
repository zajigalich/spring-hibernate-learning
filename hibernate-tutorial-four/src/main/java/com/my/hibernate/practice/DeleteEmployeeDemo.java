package com.my.hibernate.practice;

import com.my.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try(session; sessionFactory) {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1L);

            session.delete(employee);

            session.createQuery("delete Employee where firstName = 'Bonita' or lastName ='Dumb'").executeUpdate();

            session.getTransaction().commit();
        }

    }
}
