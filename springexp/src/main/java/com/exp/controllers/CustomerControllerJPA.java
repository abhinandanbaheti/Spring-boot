package com.exp.controllers;

import com.exp.persistence.Customer;
import com.exp.service.CustomerService;
import com.exp.service.CustomerServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerControllerJPA {
    @Autowired
    CustomerService custService;

    @Autowired
    CustomerServiceJPA custServiceJPA;

    // Crud Repository

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        custService.save(customer);
        return new ResponseEntity<>("Customer is created successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id) {
        Customer customer = custService.find(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCustomers() {
        return new ResponseEntity<>(custService.getAllCustomers(), HttpStatus.OK);
    }


    // JPA Repository

    @RequestMapping(value = "/customer/jpa", method = RequestMethod.POST)
    public ResponseEntity<Object> saveCustomerJPA(@RequestBody Customer customer) {
        custServiceJPA.save(customer);
        return new ResponseEntity<>("Customer is created successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/jpa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomerByIdJPA(@PathVariable("id") int id) {
        Customer customer = custServiceJPA.find(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/jpa", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCustomersJPA() {
        return new ResponseEntity<>(custServiceJPA.getAllCustomers(), HttpStatus.OK);
    }


    // JPA with Query
    @RequestMapping(value = "/customers/jpa/query", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCustomersWithQuery() {
        return new ResponseEntity<>(custServiceJPA.getAllCustomersWithQuery(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/jpa/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomerByIdJPAQuery(@PathVariable("id") int id) {
        return new ResponseEntity<>(custServiceJPA.getCustomerById(id), HttpStatus.OK);
    }

}
