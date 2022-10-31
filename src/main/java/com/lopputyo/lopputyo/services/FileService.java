package com.lopputyo.lopputyo.services;

import org.springframework.stereotype.Service;
import com.lopputyo.lopputyo.data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FileService {
    public void writeCoursesToFile(List<Course> courses) {
        try {
            FileWriter fw = new FileWriter(new File("C:\\students\\courses.txt"));
            for (Course course : courses) {
                fw.write(course.getCourse() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Course> readCoursesFromFile() {
        List<Course> courses = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("C:\\students\\courses.txt"));
            while (sc.hasNextLine()) {
                courses.add(new Course(sc.nextLine()));
            }
            return courses;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void writeStudentsToFile(List<Student> students) {
        try {
            FileWriter fw = new FileWriter(new File("C:\\students\\students.txt"));
            for (Student student : students) {
                fw.write(student.getStudent() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("C:\\students\\students.txt"));
            while (sc.hasNextLine()) {
                students.add(new Student(sc.nextLine()));
            }
            return students;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }
    }
}
