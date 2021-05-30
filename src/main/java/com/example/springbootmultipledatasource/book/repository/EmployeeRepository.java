package com.example.springbootmultipledatasource.book.repository;

import com.example.springbootmultipledatasource.model.book.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
    Employee findByEmployeeId(int i);

    //FETCH NEXT 10 ROWS ONLY
    @Query(
            value = "select * from employees where last_name='Chaluvadi' FETCH NEXT 1 ROWS ONLY",
            nativeQuery = true)
    List<Employee> findEmployees();

    Collection<NamesOnly> findByLastname(String lastName);

}
