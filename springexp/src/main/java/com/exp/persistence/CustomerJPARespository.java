package com.exp.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CustomerJPARespository extends JpaRepository<Customer, Long> {
    @Override
    List<Customer> findAll();

    List<Customer> findByLastName(String lastName);
    Customer findById(long id);

    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> findAllCustomers();

    @Query(value = "select * from customer where id=?1", nativeQuery = true)
    Customer findCustomerById(int id);
}
