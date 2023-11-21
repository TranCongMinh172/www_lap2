package com.example.www_week02.services.impls;



import com.example.www_week02.models.Customer;
import com.example.www_week02.repositories.CustomerRepository;
import com.example.www_week02.services.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CustomerImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerImpl() {
        repository = new CustomerRepository();
        repository.setType(Customer.class);
    }
    @Override
    public boolean insert(Customer customer) throws Exception {
        return repository.insert(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) throws Exception {
        return repository.findById(id);
    }


    @Override
    public List<Customer> getAll() throws Exception {
        return repository.getListResult("customer")
                .stream().collect(Collectors.toList());
    }


}
