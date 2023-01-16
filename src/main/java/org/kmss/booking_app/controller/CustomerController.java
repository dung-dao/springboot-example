package org.kmss.booking_app.controller;

import org.kmss.booking_app.entity.Customer;
import org.kmss.booking_app.service.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public Iterable<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PutMapping("/customers")
    public void createOrUpdateCustomer(@RequestBody Customer customer) {
        customerService.putCustomer(customer);
    }
}
