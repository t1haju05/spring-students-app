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

    public List<Student> students = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();

    public Services() {
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

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void removeStudent(String studentName) {
        for (Student student : students) {
            if(student.getStudent().equals(studentName)){
                int id = student.getId();
                students.remove(id);
            }
        }
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void removeCourse(String courseName) {
        for (Course course : courses) {
            if(course.getCourse().equals(courseName)){
                int id = course.getId();
                courses.remove(id);
            }
        }
    }

    public List<Student> getStudentsById(int id) {
        List<Student> found = new ArrayList<>();

        for (Student student : students) {
            if (student.getId() == id) {
                found.add(student);
            }
        }

        return found;
    }

    public List<Course> getCoursesById(int id) {
        List<Course> found = new ArrayList<>();

        for (Course course : courses) {
            if (course.getId() == id) {
                found.add(course);
            }
        }

        return found;
    }

    public List<Student> getStudentsByName(String s) {
        List<Student> found = new ArrayList<>();

        for (Student student : students) {
            if (student.getStudent().equals(s)) {
                found.add(student);
            }
        }

        return found;
    }

    public List<Course> getCoursesByName(String c) {
        List<Course> found = new ArrayList<>();

        for (Course course : courses) {
            if (course.getCourse().equals(c)) {
                found.add(course);
            }
        }

        return found;
    }

    public void addStudentToCourse(String courseName, String studentName) {
        for (Course course : courses) {
            if (course.getCourse().equals(courseName)) {
                for (Student student : students) {
                    if (student.getStudent().equals(studentName)) {
                        course.setStudents(student);
                    }
                }
            }
        }
    }

    public void removeStudentFromCourse(String courseName, String studentName) {
        for (Course course : courses) {
            if (course.getCourse().equals(courseName)) {
                for (Student student : students) {
                    if (student.getStudent().equals(studentName)) {
                        course.removeStudents(student);
                    }
                }
            }
        }
    }
}
