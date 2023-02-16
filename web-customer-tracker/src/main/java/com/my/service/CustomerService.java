package com.my.service;

import com.my.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
}
