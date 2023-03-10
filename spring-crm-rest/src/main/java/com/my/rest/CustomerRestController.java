package com.my.rest;

import com.my.entity.Customer;
import com.my.exception.CustomerNotFoundException;
import com.my.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with id = " + customerId);
        }
        return customer;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        customer.setId(null); //dao code will perform INSERT, otherwise if there is id - it will perform update
        customerService.saveCustomer(customer);
        return customer;
    }
}
