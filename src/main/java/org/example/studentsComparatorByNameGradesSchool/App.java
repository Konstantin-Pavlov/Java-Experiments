package org.example.studentsComparatorByNameGradesSchool;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

    }
}

class Student {
    private final String surName;
    private final String name;
    private final int mathGrade;
    private final int rusGrade;
    private final int infGrade;

    public Student(String surName, String name, int mathGrade, int rusGrade, int infGrade) {
        this.surName = surName;
        this.name = name;
        this.mathGrade = mathGrade;
        this.rusGrade = rusGrade;
        this.infGrade = infGrade;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public int getRusGrade() {
        return rusGrade;
    }

    public int getInfGrade() {
        return infGrade;
    }
}

class School {
    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        this.students.add(student);
    }

    public double getOverallGPA() {
        return 0.0;

    }

    public double getMathAvgGrade() {
        return 0.0;

    }

    public double getRusAvgGrade() {
        return 0.0;

    }

    public double getInfAvgGrade() {
        return 0.0;

    }
}
