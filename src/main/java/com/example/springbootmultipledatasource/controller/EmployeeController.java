package com.example.springbootmultipledatasource.controller;


import com.example.springbootmultipledatasource.cloud.DbProperties;
import com.example.springbootmultipledatasource.cloud.PropsDTO;
import com.example.springbootmultipledatasource.model.book.Employee;
import com.example.springbootmultipledatasource.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    PropsDTO propsDTO;

    @Autowired
    DbProperties dbProperties;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees")
    List<Employee> getEmployees(){

        List<Employee> employeeList=employeeService.getAllEmployess();

        return employeeList;
    }

    @GetMapping(value = "/employee/{id}")
    Employee getEmployee(@PathVariable int id){

        Employee employee=employeeService.getEmployee(id);

        return employee;
    }

    @DeleteMapping(value = "/employee/{id}")
    ResponseEntity deleteEmployee(@PathVariable int id){
       employeeService.deleteEmployee(id);
       return new ResponseEntity("Employee Got Deleted Successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/employee")
    Employee getEmployee(@RequestBody Employee employee){
        Employee employeer=employeeService.saveEmployee(employee);
        return employeer;
    }

    @GetMapping(value = "/freshvaluespr")
    void getFreshValues(){
        System.out.println(propsDTO);
    }

    @GetMapping(value = "/freshvaluesdb")
    void getFreshValuesDB() throws JsonProcessingException {
        System.out.println(dbProperties);
    }

}
