package com.my.dao;

import com.my.entity.Customer;
import com.my.util.SortUtil;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers(SortUtil sortUtil);
    void saveCustomer(Customer customer);
    Customer getCustomer(Long id);
    void deleteCustomer(Long customerId);
    List<Customer> searchCustomers(String searchPattern);
}
