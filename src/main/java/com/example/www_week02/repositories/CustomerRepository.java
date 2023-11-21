package com.example.www_week02.repositories;

import com.example.www_week02.models.Customer;

public class CustomerRepository extends  CRUDRepository<Customer>{
    public CustomerRepository() {
    }

    @Override
    public void setType(Class<Customer> type) {
        super.setType(type);
    }

}
