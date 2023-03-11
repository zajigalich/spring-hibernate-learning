package com.my.service;

import com.my.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(Long id);
    void deleteCustomer(Long id);
}
