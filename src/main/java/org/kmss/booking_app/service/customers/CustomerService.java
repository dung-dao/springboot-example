package org.kmss.booking_app.service.customers;

import java.util.List;

import org.kmss.booking_app.entity.Customer;

public interface CustomerService {
    List<Customer> findAllCustomers();

    void putCustomer(Customer customer);
}
