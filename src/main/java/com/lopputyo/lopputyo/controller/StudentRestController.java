package com.lopputyo.lopputyo.controller;

import com.lopputyo.lopputyo.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lopputyo.lopputyo.services.Services;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private Services myService;

    @GetMapping("students") // Returns all students
    public List<Student> getStudents() {
        return myService.getStudents();
    }

    @GetMapping("students/id/{id}") // Searches student by ID. students/id/ID_HERE
    public List<Student> getStudentById(@PathVariable int id) {
        return myService.getStudentsById(id);
    }

    @GetMapping("students/name/{name}") // Searches student by name. students/name/NAME_HERE
    public List<Student> GetStudentByName(@PathVariable String name) {
        return myService.getStudentsByName(name);
    }

    @GetMapping("courses") // Returns all courses
    public List<Course> getCourse() {
        return myService.getCourses();
    }

    @GetMapping("courses/id/{id}") // Searches course by ID. courses/id/ID_HERE
    public List<Course> getCourseById(@PathVariable int id) {
        return myService.getCoursesById(id);
    }

    @GetMapping("courses/name/{name}") // Searches course by name. courses/name/NAME_HERE
    public List<Course> getCourseByName(@PathVariable String name) {
        return myService.getCoursesByName(name);
    }


    @PostMapping("addstudent") // Adds student with JSON format. "student": "NAME_HERE"
    public String addStudent(@RequestBody Student student) {
        myService.students.add(student);
        myService.saveStudentsToFile();
        return "OK";

    }

    @PostMapping("addcourse") // Adds course with JSON format. "course": "NAME_HERE"
    public String addCourse(@RequestBody Course cours) {
        myService.courses.add(cours);
        myService.saveCoursesToFile();
        return "OK";
    }

    @DeleteMapping("removestudent") // Removes student using a parameter.
    public String removeStudent(@RequestParam String student) {
        myService.removeStudent(student);
        myService.saveStudentsToFile();
        return "OK";
    }

    @DeleteMapping("removecourse") // Removes student using a parameter.
    public String removeCourse(@RequestParam String course) {
        myService.removeCourse(course);
        myService.saveCoursesToFile();
        return "OK";
    }

    @PutMapping("addtocourse") // Adds to course using parameters.
    public String addToCourse(@RequestParam String courseName, @RequestParam String studentName) {
        myService.addStudentToCourse(courseName, studentName);
        return "OK";
    }

    @PutMapping("removefromcourse") // Removes from course using parameters.
    public String removeFromCourse(@RequestParam String courseName, @RequestParam String studentName) {
        myService.removeStudentFromCourse(courseName, studentName);
        return "OK";
    }
}
