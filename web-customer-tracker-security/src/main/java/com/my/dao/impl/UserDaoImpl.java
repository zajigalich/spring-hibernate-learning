package com.my.dao.impl;

import com.my.dao.UserDao;
import com.my.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where userName =:uName", User.class);

        query.setParameter("uName", userName);

        User user;

        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
