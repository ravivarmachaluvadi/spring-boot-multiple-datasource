package com.example.springbootmultipledatasource.controller;


import com.example.springbootmultipledatasource.cloud.DbProperties;
import com.example.springbootmultipledatasource.cloud.PropsDTO;
import com.example.springbootmultipledatasource.component.BulkRequest;
import com.example.springbootmultipledatasource.model.book.Employee;
import com.example.springbootmultipledatasource.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Api(value = "EmployeeController", description = "REST APIs related to Employee Entity!!!!")
public class EmployeeController {

    @Autowired
    BulkRequest bulkRequest;

    @Autowired
    PropsDTO propsDTO;

    @Autowired
    DbProperties dbProperties;

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Get list of Employees in the System ", response = Iterable.class, tags = "getEmployees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value = "/employees")
    List<Employee> getEmployees(){

        List<Employee> employeeList=employeeService.getAllEmployess();
        return employeeList;
    }

    @GetMapping(value = "/employee/{id}")
    Employee getEmployee(@PathVariable int id){

        Employee employee=employeeService.getEmployee(id);
        bulkRequest.isBulkRequest=true;
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
