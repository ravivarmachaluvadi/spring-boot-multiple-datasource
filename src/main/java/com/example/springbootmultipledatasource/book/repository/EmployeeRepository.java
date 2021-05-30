package com.example.springbootmultipledatasource.book.repository;

import com.example.springbootmultipledatasource.model.book.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

    Employee findByEmployeeId(int i);
}
