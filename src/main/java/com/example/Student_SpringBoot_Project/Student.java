package com.example.Student_SpringBoot_Project;

/**
 * Student Class that contains all properties and methods of a Student
 */
public class Student
{
    //student properties
    private Integer idNo;
    private String fullName;

    private String city;


    //default constructor
    public Student() {
    }

    //non-default constructor
    public Student(Integer idNo, String fullName, String city) {
        this.idNo = idNo;
        this.fullName = fullName;
        this.city = city;
    }


    //getters and setters
    public Integer getIdNo() {
        return idNo;
    }

    public Integer setIdNo(Integer idNo) {
        this.idNo = idNo;
        return idNo;
    }

    public String getFullName() {
        return fullName;
    }

    public String setFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
