package com.example.springbootmultipledatasource.book.repository;

import com.example.springbootmultipledatasource.model.book.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
    Employee findByEmployeeId(int i);
}
