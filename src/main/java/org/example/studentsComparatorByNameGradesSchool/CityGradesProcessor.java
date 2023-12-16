package org.example.studentsComparatorByNameGradesSchool;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class CityGradesProcessor {
    private final static List<School> schools = DataReader.getSchoolData();

    private CityGradesProcessor() {
    }

    private static double getCityMathAverageGrade() {
        // here we collect average numbers from every school. For some odd reason we get slightly wrong numbers
        // return schools.stream().mapToDouble(School::getMathAverageGrade).average().orElse(0.0);

        // here we collect all math (in that case) grades from every student from every school and get average from them. For some odd reason we get right numbers
        return getAllStudents().stream().mapToDouble(Student::getMathGrade).average().orElse(0.0);
    }

    private static double getCityRusAverageGrade() {
        // same here (look comment in getCityMathAverageGrade method)
        // return schools.stream().mapToDouble(School::getRusAverageGrade).average().orElse(0.0);

        return getAllStudents().stream().mapToDouble(Student::getRusGrade).average().orElse(0.0);

    }

    private static double getCityInfAverageGrade() {
        // same here (look comment in getCityMathAverageGrade method)
        // return schools.stream().mapToDouble(School::getInfAverageGrade).average().orElse(0.0);

        return getAllStudents().stream().mapToDouble(Student::getInfGrade).average().orElse(0.0);

    }

    private static double getCityAverageGrade() {
        return DoubleStream.of(getCityInfAverageGrade(), getCityRusAverageGrade(), getCityMathAverageGrade()).average().orElse(0.0);
    }

    public static void showMessage() {
        //образец -> Отчет по городу: математика - 72.1, русский язык - 81.3, инфрматика - 76.0, общий средний балл - 76.5
        System.out.printf(Locale.ENGLISH,
                "Отчет по городу: математика - %.1f, " +
                        "русский язык - %.1f, инфрматика - %.1f, " +
                        "общий средний балл - %.1f%n",
                getCityMathAverageGrade(),
                getCityRusAverageGrade(),
                getCityInfAverageGrade(),
                getCityAverageGrade());
    }

    public static List<Student> getAllStudents() {
        return schools.stream().flatMap(school -> school.getStudents().stream()).collect(Collectors.toList());
    }

}
