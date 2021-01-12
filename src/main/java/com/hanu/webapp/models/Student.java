package com.hanu.webapp.models;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != this.getClass()) return false;
        Student that = (Student) other;
        return this.id == that.id && this.name.equals(that.name);
    }

    @Override
    public String toString() {
        return "Student:[id=" + id + ",name=" + name + "]";
    }
}
