package com.example.www_week02.services;

import com.example.www_week02.models.Employee;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    boolean insert(Employee employee) throws Exception;
    Optional<Employee> findById(Long id) throws Exception;
    List<Employee> getAll() throws Exception;
}
