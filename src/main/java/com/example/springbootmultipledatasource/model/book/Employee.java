package com.example.springbootmultipledatasource.model.book;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
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
    @ApiModelProperty(notes = "First Name of the Employee",name="firstname",required=true,value="test name")
    @NotEmpty(message = "first name must not be empty")
    @Column(name = "FIRST_NAME")
    private String firstname;
    @NotEmpty(message = "last name must not be empty")
    @Column(name = "LAST_NAME")
    private String lastname;
    @NotEmpty(message = "email must not be empty")
    private String  EMAIL;
    private String PHONE_NUMBER;
    private Date HIRE_DATE;
    private String JOB_ID;
    @Column(name = "SALARY")
    private Float salary;
    private Float COMMISSION_PCT;
    private Integer MANAGER_ID;
    private  Integer DEPARTMENT_ID;
    //private  Integer DEPT_ID; new field with "hibernate.hbm2ddl.auto", "none" will give invalid identifier exception
    ////private  Integer DEPT_ID; new field with "hibernate.hbm2ddl.auto", "anyother"  will alter db table add new column to table
}
