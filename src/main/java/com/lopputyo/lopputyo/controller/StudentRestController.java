package com.lopputyo.lopputyo.controller;

import com.lopputyo.lopputyo.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lopputyo.lopputyo.services.StudentService;

import java.util.List;

@RestController
public class StudentRestController {
    @Autowired
    StudentService myStudentService;

    @GetMapping("students")
    public List<student> getStudents(){
        return myStudentService.getStudents();
    }

    @GetMapping("students/{course}")
    public List<student> getStudentCourses(@PathVariable String course) {
        return myStudentService.getStudentsByCourse(course);
    }

    @PostMapping("addstudent")
    public String addStudent(@RequestBody student Student){
        myStudentService.addStudent(Student);
        return "";
    }
}
