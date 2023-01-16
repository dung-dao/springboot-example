package org.kmss.booking_app.service.customers;

import org.kmss.booking_app.entity.Customer;
import org.kmss.booking_app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void putCustomer(Customer customer) {
        var uuidStr = customer.getCode() != null ? customer.getCode() : UUID.randomUUID().toString();
        var customerBuilder = customer.toBuilder().code(uuidStr);
        this.customerRepository.save(customerBuilder.build());
    }
}
