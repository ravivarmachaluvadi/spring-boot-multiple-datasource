package com.example.springbootmultipledatasource.service;

import com.example.springbootmultipledatasource.book.repository.EmployeeRepository;
import com.example.springbootmultipledatasource.model.book.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployess() {

        return employeeRepository.findAll();

    }
}
