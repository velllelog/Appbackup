package com.example.learning;

public class Constructor {
    String phone,name,grade,location,subject,fee,description;

    public Constructor() {
    }

    public Constructor(String phone, String name, String grade, String location, String subject, String fee, String description) {
        this.phone = phone;
        this.name = name;
        this.grade = grade;
        this.location = location;
        this.subject = subject;
        this.fee = fee;
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrice() {
        return fee;
    }

    public void setPrice(String price) {
        this.fee = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
