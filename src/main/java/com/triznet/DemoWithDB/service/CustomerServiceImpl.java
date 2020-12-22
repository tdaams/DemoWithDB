package com.triznet.DemoWithDB.service;

import com.triznet.DemoWithDB.exception.DatabaseErrorException;
import com.triznet.DemoWithDB.exception.RecordNotFoundException;
import com.triznet.DemoWithDB.model.Customer;
import com.triznet.DemoWithDB.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteCustomer(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void updateCustomer(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            try {
                Customer existingCustomer = customerRepository.findById(id).orElse(null);
                existingCustomer.setFirstName(customer.getFirstName());
                existingCustomer.setLastName(customer.getLastName());
                existingCustomer.setCustomerNr(customer.getCustomerNr());
                customerRepository.save(existingCustomer);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Customer getCustomerByLastName(String lastName) {
        try {
            return customerRepository.findByLastNameIgnoreCase(lastName);
        }
        catch (Exception ex ) {
            throw new RecordNotFoundException();
        }
    }

}
