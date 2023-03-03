package com.my.service.impl;

import com.my.dao.CustomerDAO;
import com.my.entity.Customer;
import com.my.service.CustomerService;
import com.my.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional("myTransactionManager")
    public List<Customer> getCustomers(SortUtil sortUtil) {
        return customerDAO.getCustomers(sortUtil);
    }

    @Override
    @Transactional("myTransactionManager")
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional("myTransactionManager")
    public Customer getCustomer(Long id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional("myTransactionManager")
    public void deleteCustomer(Long customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    @Override
    @Transactional("myTransactionManager")
    public List<Customer> searchCustomers(String searchName) {
        return customerDAO.searchCustomers(searchName);
    }

}
