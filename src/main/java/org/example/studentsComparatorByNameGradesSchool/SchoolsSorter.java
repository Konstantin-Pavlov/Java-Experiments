package org.example.studentsComparatorByNameGradesSchool;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolsSorter {
    private static final List<School> schools = DataReader.getSchoolData();

    private SchoolsSorter() {
    }

    private static List<School> getSortedSchools() {
        return schools.stream()
                .sorted(Comparator
                        .comparing(School::getOverallGPA).reversed()
                        .thenComparing(School::getMathAverageGrade).reversed()
                        .thenComparing(School::getRusAverageGrade).reversed()
                        .thenComparing(School::getInfAverageGrade).reversed()
                        .thenComparing(School::getSchoolNumber).reversed()
                )
                .collect(Collectors.toList());
    }

    public static void printSortedSchools() {
        getSortedSchools().forEach(System.out::println);
    }

}
