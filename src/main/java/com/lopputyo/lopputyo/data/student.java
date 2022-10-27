package com.lopputyo.lopputyo.data;

public class Student {
    private int id;
    private String student;
    private static int count = 0;

    public Student(){
        this("");
    }

    public Student(String name){
        this.student = name;
        this.id = count++;
    }

    public String getStudent(){
        return this.student;
    }
    
    public void setName(String name){
        this.student = name;
    }

    public int getId(){
        return this.id;
    }
}
