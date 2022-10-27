package com.lopputyo.lopputyo.controller;

import com.lopputyo.lopputyo.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lopputyo.lopputyo.services.Services;

import java.util.List;

@RestController
public class StudentRestController {
    
    @Autowired
    Services myService;

    @GetMapping("students")
    public List<Student> getStudents(){
        return myService.getStudents();
    }

    @GetMapping("courses")
    public List<Course> getCourse() {
        return myService.getCourses();
    }

    @PostMapping("addstudent")
    public Student addStudent(@RequestBody Student student){
        myService.addStudent(student);
        return student;
    }
}
