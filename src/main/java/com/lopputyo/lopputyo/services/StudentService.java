package com.lopputyo.lopputyo.services;
import com.lopputyo.lopputyo.data.student;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    StudentFileService fileService;
    private List<student> students = new ArrayList<>();


    public StudentService(){
        try {
            students = fileService.readStudentsFromFile();
        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(student Student){
        students.add(Student);
    }

    public List<student> getStudents(){
        return new ArrayList<>(students);
    }

    public List<student> getStudentsByCourse(String course){
        List<student> foundStudents = new ArrayList<>();

        for(student s : students){
            if(s.getCourses().equals(course)){
                foundStudents.add(s);
            }
        }
        
        return foundStudents;
    }
}
