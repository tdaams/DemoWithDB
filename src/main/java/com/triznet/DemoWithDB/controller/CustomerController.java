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

    @GetMapping(value = "/clients")
    public ResponseEntity<Object> getClients() {
        List<Customer> clients = customerService.getAllCustomers();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Object> getClient(@PathVariable("id") long id) {
        Customer client = customerService.getCustomerById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<Object> saveClient(@RequestBody Customer customer) {
        long newId = customerService.saveCustomer(customer);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable("id") int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/clients/lastname/{lastname}")
    public ResponseEntity<Object> getClientByLastName(@PathVariable("lastname") String lastName) {
        Customer client = customerService.getCustomerByLastName(lastName);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
