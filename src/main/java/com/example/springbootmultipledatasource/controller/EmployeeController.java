package com.example.springbootmultipledatasource.controller;


import com.example.springbootmultipledatasource.cloud.PropsDTO;
import com.example.springbootmultipledatasource.model.book.Employee;
import com.example.springbootmultipledatasource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    PropsDTO propsDTO;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees")
    List<Employee> getEmployess(){

        List<Employee> employeeList=employeeService.getAllEmployess();

        return employeeList;
    }

    @GetMapping(value = "/freshvalues")
    PropsDTO getFreshValues(){
        return propsDTO;
    }

}
