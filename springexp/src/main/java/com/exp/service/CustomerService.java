package com.exp.service;

import com.exp.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exp.persistence.Customer;
import java.util.*;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer find(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers(){
        Iterable ite = customerRepository.findAll();
        List<Customer> list = new ArrayList<Customer>();
        Iterator it = ite.iterator();
        while(it.hasNext()){
            Customer cust = (Customer)it.next();
            list.add(cust);
        }
        return list;
    }

}
