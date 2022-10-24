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
public class StudentFileService {
    public void writeStudentsToFile(List<student> students) throws IOException {
        FileWriter fw = new FileWriter(new File("students.txt"));
        fw.close();
    }

    public List<student> readStudentsFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("students.txt"));
        List<student> students = new ArrayList<>();
        while(sc.hasNextLine()){
            String row = sc.nextLine();
            students.add(0, row);
        }

        return students;
    }
}
