package com.example.learning;

public class ConstructorStudent {
    String name, location, phone, grade;

    //empty constructor
    public ConstructorStudent(){

    }

    public ConstructorStudent(String name, String location, String phone, String grade) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
