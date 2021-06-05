package com.example.springbootmultipledatasource.employee;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Emp> empList = EmployeeStore.empList;

        List<EmpMini> empMiniList = empList.stream().map(Main::apply).collect(Collectors.toList());

        empMiniList.forEach(System.out::println);
    }

    private static EmpMini apply(Emp emp) {
        EmpMini empMini = new EmpMini();

        empMini.setGender(emp.getGender());
        empMini.setName(emp.getName());
        empMini.setSalary(emp.getSalary());
        return empMini;
    }
}
