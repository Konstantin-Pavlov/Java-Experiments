package org.example.studentsComparatorByNameGradesSchool;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.DoubleStream;

public class School {
    private final List<Student> students = new ArrayList<>();
    private final int schoolNumber;

    public School(String surName, String name, int schoolNumber, int mathGrade, int rusGrade, int infGrade) {
        Student student = new Student(surName, name, mathGrade, rusGrade, infGrade);
        this.add(student);
        this.schoolNumber = schoolNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public double getOverallGPA() {
        return DoubleStream.of(getMathAverageGrade(), getRusAverageGrade(), getInfAverageGrade()).average().orElse(0.0);

    }

    public double getMathAverageGrade() {
        return students.stream().mapToDouble(Student::getMathGrade).average().orElse(0.0);
    }

    public double getRusAverageGrade() {
        return students.stream().mapToDouble(Student::getRusGrade).average().orElse(0.0);
    }

    public double getInfAverageGrade() {
        return students.stream().mapToDouble(Student::getInfGrade).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return String
                .format(Locale.ENGLISH,
                        "Школа № %d: математика - %.1f, " +
                                "русский язык - %.1f, " +
                                "инфрматика - %.1f, " +
                                "общий средний балл - %.1f",
                        getSchoolNumber(),
                        getMathAverageGrade(),
                        getRusAverageGrade(),
                        getInfAverageGrade(),
                        getOverallGPA());
    }
}
