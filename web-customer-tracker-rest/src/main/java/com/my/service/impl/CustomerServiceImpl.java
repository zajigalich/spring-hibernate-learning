package com.my.service.impl;

import com.my.model.Customer;
import com.my.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final RestTemplate restTemplate;
    private final String crmRestUrl;

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public CustomerServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String crmRestUrl) {
        this.restTemplate = restTemplate;
        this.crmRestUrl = crmRestUrl;

        logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
    }

    @Override
    public List<Customer> getCustomers() {

        logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

        // make REST call
        ResponseEntity<List<Customer>> responseEntity =
                restTemplate.exchange(crmRestUrl, HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<Customer>>() {
                        });

        List<Customer> customers = responseEntity.getBody();

        logger.info("in getCustomers(): customers" + customers);

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        logger.info("in saveCustomers(): Calling REST API " + crmRestUrl);

        // make REST call
        if (customer.getId() == null) {
            // add employee
            restTemplate.postForEntity(crmRestUrl, customer, Customer.class);
        } else {
            // update employee
            restTemplate.put(crmRestUrl, customer);
        }

        logger.info("in saveCustomer(): success");
    }

    @Override
    public Customer getCustomer(Long id) {

        logger.info("in getCustomers(): Calling REST API " + crmRestUrl + "/" + id);

        // make REST call
        Customer customer =
                restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);

        logger.info("in getCustomer(): theCustomer=" + customer);

        return customer;
    }

    @Override
    public void deleteCustomer(Long id) {
        logger.info("in deleteCustomers(): Calling REST API " + crmRestUrl + "/" + id);

        // make REST call
        restTemplate.delete(crmRestUrl + "/" + id);

        logger.info("in deleteCustomer(): deleted customer theId=" + id);
    }
}
