package com.my.service;

import com.my.entity.Customer;
import com.my.util.SortUtil;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers(SortUtil sortUtil);
    void saveCustomer(Customer customer);
    Customer getCustomer(Long id);
    void deleteCustomer(Long customerId);
    List<Customer> searchCustomers(String searchName);
}
