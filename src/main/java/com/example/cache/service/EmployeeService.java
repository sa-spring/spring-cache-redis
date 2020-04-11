package com.example.cache.service;

import java.util.List;

import com.example.cache.model.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee save(Employee employee);

    void delete(long employeeId);
}
