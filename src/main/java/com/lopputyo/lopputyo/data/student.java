package com.lopputyo.lopputyo.data;

public class Student {
    private int id;
    private String name;
    private static int count = 0;

    public Student(String name){
        this.name = name;
        this.id = count++;
    }

    public String getStudent(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }
}
