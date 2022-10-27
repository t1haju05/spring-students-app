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

    @GetMapping("students/id/{id}")
    public List<Student> getStudentById(@PathVariable int id){
        return myService.getStudentsById(id);
    }

    @GetMapping("students/name/{name}")
    public List<Student> GetStudentByName(@PathVariable String name){
        return myService.getStudentsByName(name);
    }

    @GetMapping("courses")
    public List<Course> getCourse() {
        return myService.getCourses();
    }

    @GetMapping("courses/id/{id}")
    public List<Course> getCourseById(@PathVariable int id){
        return myService.getCoursesById(id);
    }

    @GetMapping("courses/name/{name}")
    public List<Course> getCourseByName(@PathVariable String name){
        return myService.getCoursesByName(name);
    }


    /* Student Lisätään "student": "nimi" */

    @PostMapping("addstudent") 
    public String addStudent(@RequestBody Student student){
        myService.students.add(student);
        return "OK";

    }

      /* Course Lisätään "course": "nimi" */

    @PostMapping("addcourse")
    public String addCourse(@RequestBody Course cours){
        myService.courses.add(cours);
        return "OK";
    }

    @DeleteMapping("removestudent")
    public String removeStudent(@RequestParam String student){
        myService.removeStudent(student);
        return "OK";
    }

    @DeleteMapping("removecourse")
    public String removeCourse(@RequestParam String course){
        myService.removeCourse(course);
        return "OK";
    }

    @PutMapping("addtocourse")
    public String addToCourse(@RequestParam String courseName, @RequestParam String studentName) {
        myService.addStudentToCourse(courseName, studentName);
        return "OK";
    }

    @PutMapping("removefromcourse")
    public String removeFromCourse(@RequestParam String courseName, @RequestParam String studentName) {
        myService.removeStudentFromCourse(courseName, studentName);
        return "OK";
    }
}
