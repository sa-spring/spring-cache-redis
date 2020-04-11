package com.example.cache.service;

import java.util.List;
import java.util.Optional;

import com.example.cache.model.Employee;
import com.example.cache.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)
    public void delete(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()){
            employeeRepository.delete(employee.get());

        }
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
