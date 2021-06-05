package com.example.springbootmultipledatasource.service;

import com.example.springbootmultipledatasource.book.repository.EmployeeRepository;
import com.example.springbootmultipledatasource.exception.RecordNotFoundException;
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

    public Employee getEmployee(int id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        if(employee==null){
            throw new RecordNotFoundException("Invalid employee id : " + id);
        }
        return employee;
    }

    public Employee saveEmployee(Employee employee) {
        Employee employeer = employeeRepository.save(employee);
        return employeer;
    }

    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        if(employee==null){
            throw new RecordNotFoundException("Invalid employee id : " + id);
        }
        employeeRepository.deleteById(id);
        }
}
