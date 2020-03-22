package com.exp.service;


import com.exp.persistence.Customer;
import com.exp.persistence.CustomerJPARespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerServiceJPA {

    @Autowired
    CustomerJPARespository customerJPA;

    public void save(Customer customer) {
        customerJPA.save(customer);
    }

    public Customer find(int id) {
        return customerJPA.findById(id);
    }

    public List<Customer> getAllCustomers(){
        return customerJPA.findAll();
    }

    public List<Customer> getAllCustomersWithQuery(){
        return customerJPA.findAllCustomers();
    }

    public Customer getCustomerById(int id){
        return customerJPA.findCustomerById(id);
    }
}
