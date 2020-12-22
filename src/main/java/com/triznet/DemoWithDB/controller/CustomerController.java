package com.triznet.DemoWithDB.controller;

import com.triznet.DemoWithDB.model.Customer;
import com.triznet.DemoWithDB.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer")
    public ResponseEntity<Object> getCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        long newId = customerService.saveCustomer(customer);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/customer/lastname/{lastname}")
    public ResponseEntity<Object> getCustomerByLastName(@PathVariable("lastname") String lastName) {
        Customer customer = customerService.getCustomerByLastName(lastName);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
