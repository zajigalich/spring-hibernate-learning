package com.my.demo;

import com.my.entity.Instructor;
import com.my.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteBiDirectionalDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try(sessionFactory; session) {

            session.beginTransaction();

            long id = 7;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("instructor = " + instructor);

            if (instructor != null){
                System.out.println("Deleting");
                session.delete(instructor);
            }

            /*id = 4;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("instructorDetail = " + instructorDetail);

            if (instructorDetail != null){
                System.out.println("Deleting");
                session.delete(instructorDetail);
            }*/
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
