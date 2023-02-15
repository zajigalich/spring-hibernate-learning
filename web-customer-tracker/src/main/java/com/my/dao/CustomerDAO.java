package com.my.dao;

import com.my.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    /*Customer getCustomer(Long id);
    boolean deleteCustomer(Customer customer);
    boolean updateCustomer(Customer customer);*/
}
