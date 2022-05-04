package com.peter.dataresoverdemo.Student;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int age;

    public static final String TABLE_NAME = "tb_student";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_GENDER = "gender";
    public static final String COL_AGE = "age";

    public Student() {

    }

    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
