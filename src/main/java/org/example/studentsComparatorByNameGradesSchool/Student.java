package org.example.studentsComparatorByNameGradesSchool;

import java.util.Objects;

public class Student {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return surName.equals(student.surName) && name.equals(student.name)
                && mathGrade == student.mathGrade && rusGrade == student.rusGrade && infGrade == student.infGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surName, name, mathGrade, rusGrade, infGrade);
    }

    @Override
    public String toString() {
        return String.format("name: %-10s |  surname: %-10s | math grade: %-3d | rus grade: %-3d | inf grade: %-3d%n", name, surName, mathGrade, rusGrade, rusGrade);
    }
}
