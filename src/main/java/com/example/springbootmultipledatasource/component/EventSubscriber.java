package com.example.springbootmultipledatasource.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventSubscriber {

    @Autowired
    BulkRequest bulkRequest;

    @AfterReturning("execution(* com.example.springbootmultipledatasource.controller.EmployeeController.getEmployees())")
    public void run(JoinPoint joinPoint){
        if(bulkRequest.isBulkRequest){
            System.out.println("Received Bulk Request");
        }
    }

}