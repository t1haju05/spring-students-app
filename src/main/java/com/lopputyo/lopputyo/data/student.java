package com.lopputyo.lopputyo.data;
import java.util.ArrayList;

public class student {
    private int id;
    private String name;
    private ArrayList<String> courses;

    private static int count = 0;

    public student(String name, String course){
        this.name = name;
        this.courses.add(course);
        this.id = count++;
    }
    public student(){
        this("","");
    }

    public String getStudentName(){
        return this.name;
    }
    
    public void setStudentName(String name){
        this.name = name;
    }
    
    public String getCourses(){
        return this.courses.toString();
    }

    public void setCourses(String course){
        this.courses.add(course);
    }

    public int getId(){
        return this.id;
    }
}
