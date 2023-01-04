package com.wai.demo.controller;

import com.wai.demo.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping
    List<Student> submsaitStudents(@RequestBody Student student){
        return null;
    }
}
