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
    public void writeCoursesToFile(List<Course> courses) throws IOException {
        FileWriter fw = new FileWriter(new File("courses.txt"));
        for (Course course : courses) {
            fw.write(course + System.lineSeparator());
        }
    }

    public List<Student> readStudentsFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("students.txt"));
        List<Student> students = new ArrayList<>();
        while(sc.hasNext()){
            students.add(new Student(sc.next()));
        }

        return students;
    }
}
