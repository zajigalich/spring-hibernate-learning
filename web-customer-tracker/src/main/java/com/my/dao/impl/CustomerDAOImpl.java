package com.my.dao.impl;

import com.my.dao.CustomerDAO;
import com.my.entity.Customer;
import com.my.util.SortUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers(SortUtil sortUtil) {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query =
                session.createQuery("from Customer order by " + sortUtil.getSortingField(), Customer.class);

        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("delete from Customer where id=:customerId", Customer.class);
        query.setParameter("customerId", customerId);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers;
        Query<Customer> query;

        if (searchName != null && !searchName.isBlank()) {
            searchName = searchName.trim().toLowerCase();
            query = session
                    .createQuery("from Customer " +
                            "where lower(firstName) like :searchName " +
                            "or lower(lastName) like :searchName", Customer.class);

            query.setParameter("searchName", "%" + searchName + "%");

        } else {
            query = session.createQuery("from Customer", Customer.class);
        }

        customers = query.getResultList();
        return customers;
    }

}
