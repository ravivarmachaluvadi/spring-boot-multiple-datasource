package com.example.springbootmultipledatasource.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

   static List<Emp> empList = new ArrayList<>();

    static {
        empList.add(new Emp(133, "C", 29, "M", "Infra", 2012, 18000.0));
        empList.add(new Emp(122, "B", 25, "M", "Sales", 2015, 13500.0));
        empList.add(new Emp(111, "A", 32, "F", "HR", 2011, 25000.0));
        empList.add(new Emp(144, "D", 28, "M", "Development", 2014, 32500.0));
        empList.add(new Emp(155, "E", 27, "F", "HR", 2013, 22700.0));
        empList.add(new Emp(166, "F", 43, "M", "Security", 2016, 10500.0));
        empList.add(new Emp(177, "G", 35, "M", "Finance", 2010, 27000.0));
        empList.add(new Emp(188, "H", 31, "M", "Development", 2015, 34500.0));
        empList.add(new Emp(199, "I", 24, "F", "Sales", 2016, 11500.0));
        empList.add(new Emp(200, "J", 38, "M", "Security", 2015, 11000.5));
        empList.add(new Emp(211, "K", 27, "F", "Infra", 2014, 15700.0));
        empList.add(new Emp(222, "L", 25, "M", "Development", 2016, 28200.0));
        empList.add(new Emp(233, "M", 27, "F", "Finance", 2013, 21300.0));
        empList.add(new Emp(244, "N", 24, "M", "Sales", 2017, 10700.5));
        empList.add(new Emp(255, "O", 23, "M", "Infra", 2018, 12700.0));
        empList.add(new Emp(266, "P", 26, "F", "Development", 2015, 28900.0));
        empList.add(new Emp(277, "Q", 31, "M", "Development", 2012, 35700.0));
    }
}
