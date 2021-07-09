package com.example.springbootmultipledatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class NativeNonEntityController {

   /* @Autowired
    EntityManager entityManager;
*/
   /* @Autowired
    JdbcTemplate jdbcTemplate;*/

    @Autowired
    @Qualifier(value = "bookEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/native/sql")
    void get50Photos(){
        System.out.println();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNativeQuery("select e.first_name,d.department_name from employees e,departments d where e.department_id = d.department_id");

        List<Object[]> resultList= query.getResultList();

        resultList.stream().forEach(objects -> System.out.println(" first_name "+objects[0]+" , department_name "+objects[1]));

    }

}
