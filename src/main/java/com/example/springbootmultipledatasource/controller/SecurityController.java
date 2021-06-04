package com.example.springbootmultipledatasource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping(value = "/")
     String hello()  {

        return "Hello , World";
    }

    @GetMapping(value = "/admin")
    String helloAdmin() {

        return "Hello , ADMIN";
    }

    @GetMapping(value = "/user")
    String helloUser()  {

        return "Hello , USER";
    }

}
