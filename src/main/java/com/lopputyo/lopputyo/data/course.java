package com.lopputyo.lopputyo.data;

public class course {
    private int id;
    private String courseName;
    private String courseType;

    private static int count = 0;

    public course(String name, String type){
        this.courseName = name;
        this.courseType = type;
        this.id = count++;
    }

    public course(){
        this("","");
    }

    public String getCourseName(){
        return this.courseName;
    }
    public void setCourseName(String course){
        this.courseName = course;
    }
    public String getCourseType(){
        return this.courseType;
    }
    public void setCourseType(String type){
        this.courseType = type;
    }
    public int getCourseId(){
        return this.id;
    }
}
