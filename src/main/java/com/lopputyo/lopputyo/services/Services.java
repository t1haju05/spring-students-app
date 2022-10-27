package com.lopputyo.lopputyo.services;
import com.lopputyo.lopputyo.data.Course;
import com.lopputyo.lopputyo.data.Student;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class Services {
    @Autowired
    FileService myFileService;

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();


    public Services(){
        students.add(new Student("Adde"));
        students.add(new Student("Jere"));
        students.add(new Student("Liisa"));
        students.add(new Student("Tarja"));
        students.add(new Student("Huovinen"));

        Course course1 = new Course("Äidinkieli");
        Course course2 = new Course("Ohjelmointi");

        course1.students.add(students.get(0));
        course1.students.add(students.get(1));
        course1.students.add(students.get(4));

        course2.students.add(students.get(3));
        course2.students.add(students.get(2));

        courses.add(course1);
        courses.add(course2);

    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

    public List<Course> getCourses(){
        return new ArrayList<>(courses);
    }

    public Student getStudentsById(int id){
        for (Student student : students) {
            if(student.getId() == id){
                return student;
            }
        }

        return null;
    }

    public Course getCoursesById(int id){
        for (Course course : courses) {
            if(course.getId() == id){
                return course;
            }
        }

        return null;
    }


    public List<Student> getStudentsByName(String s){
        List<Student> found = new ArrayList<>();

        for(Student student : students){
            if(student.getStudent().equals(s)){
                found.add(student);
            }
        }
        
        return found;
    }

    public List<Course> getCoursesByName(String c){
        List<Course> found = new ArrayList<>();

        for(Course course : courses){
            if(course.getCourse().equals(c)){
                found.add(course);
            }
        }
        
        return found;
    }
}
