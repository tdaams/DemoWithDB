package com.triznet.DemoWithDB.service;

import com.triznet.DemoWithDB.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(long id);
    void deleteCustomer(long id);
    long saveCustomer(Customer client);
    void updateCustomer(long id, Customer customer);
    Customer getCustomerByLastName(String lastName);

}
