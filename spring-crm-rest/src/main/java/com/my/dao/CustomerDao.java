package com.my.dao;

import com.my.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();
    Customer getCustomer(Long id);
    void deleteCustomer(Long id);
    void saveCustomer(Customer customer);
}
