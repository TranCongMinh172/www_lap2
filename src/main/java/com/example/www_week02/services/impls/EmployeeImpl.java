package com.example.www_week02.services.impls;



import com.example.www_week02.models.Employee;
import com.example.www_week02.repositories.EmployeeRepository;
import com.example.www_week02.services.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeImpl() {
        repository = new EmployeeRepository();
        repository.setType(Employee.class);
    }

    @Override
    public boolean insert(Employee employee) throws Exception {
        return repository.insert(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public List<Employee> getAll() throws Exception {
        return repository.getListResult("employee")
                .stream()
                .collect(Collectors.toList());
    }
}
