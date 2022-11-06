package com.wai.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Application {

    @GetMapping("/message")
    public String hello() {
        return "Welcome Spring Boot & VueJS!";
    }
}
