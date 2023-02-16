package com.my.dao;

import com.my.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(Long id);

}
