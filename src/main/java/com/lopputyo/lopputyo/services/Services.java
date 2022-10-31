package com.lopputyo.lopputyo.services;

import com.lopputyo.lopputyo.data.Course;
import com.lopputyo.lopputyo.data.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class Services {
    @Autowired
    FileService myFileService;

    public List<Student> students = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();

    public Services() {
        /* You can add students and courses from here if you uncomment
         * students.add(new Student("name1"));
         * students.add(new Student("name2"));
         * students.add(new Student("name3"));
         * students.add(new Student("name4"));
         * 
         * Course course1 = new Course("Cloud");
         * Course course2 = new Course("Programming");
         * 
         * course1.students.add(students.get(0));
         * course1.students.add(students.get(1));
         * course1.students.add(students.get(4));
         * 
         * course2.students.add(students.get(3));
         * course2.students.add(students.get(2));
         * 
         * courses.add(course1);
         * courses.add(course2);
         */
        FileService fs = new FileService();
        courses = fs.readCoursesFromFile();
        students = fs.readStudentsFromFile();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void removeStudent(String studentName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudent().equals(studentName)) {
                students.remove(students.get(i));
            }
        }
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void removeCourse(String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourse().equals(courseName)) {
                courses.remove(courses.get(i));
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

    public void saveStudentsToFile() {
        myFileService.writeStudentsToFile(students);
    }

    public void saveCoursesToFile() {
        myFileService.writeCoursesToFile(courses);
    }
}
