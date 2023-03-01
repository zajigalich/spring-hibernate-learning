package com.my.dao.impl;

import com.my.dao.RoleDao;
import com.my.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role findRoleByName(String roleName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Role> query = session.createQuery("from Role where name =:roleName", Role.class);
        query.setParameter("roleName", roleName);

        Role role;

        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            role = null;
        }

        return role;
    }
}
