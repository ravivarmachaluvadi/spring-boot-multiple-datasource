package com.example.springbootmultipledatasource.employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeComparator {

    public static void main(String[] args) {

        List<Emp> empList = EmployeeStore.empList;

        empList.forEach(System.out::println);

        System.out.println(" =============================================== ");

        Comparator<Emp> ageAndDeptComparator = Comparator.comparing(Emp::getAge).thenComparing(Emp::getDepartment);

        empList.sort(ageAndDeptComparator);

        empList.forEach(System.out::println);

    }

}
