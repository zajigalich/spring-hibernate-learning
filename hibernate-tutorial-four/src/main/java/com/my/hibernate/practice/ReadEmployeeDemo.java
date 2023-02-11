package com.my.hibernate.practice;

import com.my.entity.Employee;
import com.my.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try(session; sessionFactory) {
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1L);
            System.out.println("employee = " + employee);

            List<Employee> employeeList = session.createQuery("from Employee").getResultList();

            System.out.println("\nstudentList = " + employeeList);

            employeeList = session.createQuery("from Employee e where e.firstName = 'Tomcat' or e.lastName = 'Stick'").getResultList();

            System.out.println("\nstudentList = " + employeeList);


            session.getTransaction().commit();
        }

    }
}
