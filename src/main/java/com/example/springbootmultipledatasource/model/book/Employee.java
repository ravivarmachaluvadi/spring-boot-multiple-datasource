package com.example.springbootmultipledatasource.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEES",schema = "HR")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String  EMAIL;
    private String PHONE_NUMBER;
    private Date HIRE_DATE;
    private String JOB_ID;
    private Float SALARY;
    private Float COMMISSION_PCT;
    private Integer MANAGER_ID;
    private  Integer DEPARTMENT_ID;
}
