package com.lopputyo.lopputyo.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    public List<Student> students = new ArrayList<>();
    private static int count = 0;

    public Course() {
        this("");
    }

    public Course(String name) {
        this.id = count++;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getCourse() {
        return this.name;
    }

    public void setCourse(String name) {
        this.name = name;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    public void removeStudents(Student student) {
        this.students.remove(student);
    }

    public String getStudents() {
        String s = "";
        for (Student student : students) {
            s += student.getStudent() + " ";
        }
        return s;
    }
}
