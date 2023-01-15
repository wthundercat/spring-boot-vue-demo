package com.wai.demo.controller;

import com.wai.demo.entity.Room;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping
    List<Room> submsaitStudents(@RequestBody Room student){
        //retrieve records from teh database
        return null;
    }
}
