package com.example.springbootmultipledatasource.employee;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class EmpInterview {
    public static void main(String[] args) {


        List<Emp> empList = EmployeeStore.empList;

        //Count * by department
        Map<String, Long> countStarByDepartment =
                empList.stream().collect(Collectors.groupingBy(Emp::getDepartment, Collectors.counting()));

        System.out.println(countStarByDepartment);

        //Avg age of Male and Female Employees
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
                empList.stream().collect(Collectors.groupingBy(Emp::getGender, Collectors.averagingInt(Emp::getAge)));

        System.out.println(avgAgeOfMaleAndFemaleEmployees);

        //highest paid employee in the organization
        Optional<Emp> highestPaidEmployeeWrapper=
                empList.stream().max(Comparator.comparingDouble(Emp::getSalary));

        AtomicReference<Emp> highestPaidEmployee = new AtomicReference<>();
        highestPaidEmployeeWrapper.ifPresent(highestPaidEmployee::set);

        System.out.println("Details Of Highest Paid Employee : ");
        System.out.println("==================================");
        System.out.println("ID : "+ highestPaidEmployee.get().getId());
        System.out.println("Name : "+ highestPaidEmployee.get().getName());
        System.out.println("Age : "+ highestPaidEmployee.get().getAge());
        System.out.println("Gender : "+ highestPaidEmployee.get().getGender());
        System.out.println("Department : "+ highestPaidEmployee.get().getDepartment());
        System.out.println("Year Of Joining : "+ highestPaidEmployee.get().getYearOfJoining());
        System.out.println("Salary : "+ highestPaidEmployee.get().getSalary());


        //names of all employees who have joined after 2015
        final List<String> collect = empList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Emp::getName)
                .collect(Collectors.toList());
        //.forEach(System.out::println);

        //youngest male employee in the product development department
        Optional<Emp> youngestMaleEmployeeInProductDevelopmentWrapper=
                empList.stream()
                        .filter(e -> e.getGender().equals("M") && e.getDepartment().equals("Development"))
            .min(Comparator.comparingInt(Emp::getAge));


        AtomicReference<Emp> youngestMaleEmployeeInProductDevelopment = new AtomicReference<>();

                youngestMaleEmployeeInProductDevelopmentWrapper.ifPresent(youngestMaleEmployeeInProductDevelopment::set);

        System.out.println("Details Of Youngest Male Employee In Product Development");
        System.out.println("----------------------------------------------");
        System.out.println("ID : "+ youngestMaleEmployeeInProductDevelopment.get().getId());
        System.out.println("Name : "+ youngestMaleEmployeeInProductDevelopment.get().getName());
        System.out.println("Age : "+ youngestMaleEmployeeInProductDevelopment.get().getAge());
        System.out.println("Year Of Joinging : "+ youngestMaleEmployeeInProductDevelopment.get().getYearOfJoining());
        System.out.println("Salary : "+ youngestMaleEmployeeInProductDevelopment.get().getSalary());

        //Who has the most working experience in the organization
        Optional<Emp> seniorMostEmployeeWrapper=
                empList.stream().min(Comparator.comparingInt(Emp::getYearOfJoining));


        AtomicReference<Emp> seniorMostEmployee = new AtomicReference<>();
                seniorMostEmployeeWrapper.ifPresent(seniorMostEmployee::set);

        System.out.println("Senior Most Employee Details :");
        System.out.println("----------------------------");
        System.out.println("ID : "+ seniorMostEmployee.get().getId());
        System.out.println("Name : "+ seniorMostEmployee.get().getName());
        System.out.println("Age : "+ seniorMostEmployee.get().getAge());
        System.out.println("Gender : "+ seniorMostEmployee.get().getGender());
        System.out.println("Age : "+ seniorMostEmployee.get().getDepartment());
        System.out.println("Year Of Joinging : "+ seniorMostEmployee.get().getYearOfJoining());
        System.out.println("Salary : "+ seniorMostEmployee.get().getSalary());

        //How many male and female employees are there in the sales and marketing team
        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
                empList.stream()
                        .filter(e -> e.getDepartment().equals("Sales And Marketing"))
                        .collect(Collectors.groupingBy(Emp::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleEmployeesInSalesMarketing);

        //List down the names of all employees in each department?
        Map<String, List<Emp>> employeeListByDepartment=
                empList.stream().collect(Collectors.groupingBy(Emp::getDepartment));

        Set<Map.Entry<String, List<Emp>>> entrySet = employeeListByDepartment.entrySet();

        for (Map.Entry<String, List<Emp>> entry : entrySet)
        {
            System.out.println("--------------------------------------");
            System.out.println("Employees In "+entry.getKey() + " : ");
            System.out.println("--------------------------------------");
            List<Emp> list1 = entry.getValue();
            for (Emp e : list1)
            {
                System.out.println(e.getName());
            }
        }
    }
}







