package com.my.service.impl;

import com.my.model.Customer;
import com.my.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomer(Long id) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
