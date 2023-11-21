package com.example.www_week02.repositories;

import com.example.www_week02.models.Employee;

public class EmployeeRepository extends  CRUDRepository<Employee>{
    public EmployeeRepository() {
    }

    @Override
    public void setType(Class<Employee> type) {
        super.setType(type);
    }
}
