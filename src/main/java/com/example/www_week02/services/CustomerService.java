package com.example.www_week02.services;

import com.example.www_week02.models.Customer;
import com.example.www_week02.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean insert(Customer customer) throws Exception;
    Optional<Customer> findById(Long id) throws Exception;
    List<Customer> getAll() throws Exception;
}
