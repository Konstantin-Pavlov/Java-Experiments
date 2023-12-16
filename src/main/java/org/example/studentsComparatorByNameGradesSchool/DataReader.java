package org.example.studentsComparatorByNameGradesSchool;


import java.util.*;
import java.util.stream.Collectors;

public class DataReader {
    private static final List<School> schools = readSchoolData();
//    private static final List<School> schools = readUserInput();

    private DataReader() {
    }

    private static List<School> readUserInput() {
        String[] data = getUserInput();

        Map<Integer, School> schoolMap = new HashMap<>();

        return Arrays.stream(data)
                .map(d -> {
                    String[] parts = d.trim().split(" ");
                    String surName = parts[0];
                    String name = parts[1];
                    int schoolNumber = Integer.parseInt(parts[2]);
                    int mathGrade = Integer.parseInt(parts[3]);
                    int rusGrade = Integer.parseInt(parts[4]);
                    int infGrade = Integer.parseInt(parts[5]);

                    School school = schoolMap.computeIfAbsent(schoolNumber, key -> new School(surName, name, schoolNumber, mathGrade, rusGrade, infGrade));
                    Student student = new Student(surName, name, mathGrade, rusGrade, infGrade);
                    if (!school.getStudents().contains(student)) {
                        school.add(student);
                    }
                    return school;
                })
                .distinct()
                .collect(Collectors.toList());
    }

    private static String[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        scanner.nextLine();
        String[] data = new String[numberOfElements];
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    private static List<School> readSchoolData() {
        String[] data = new String[]{
                " Иванов Иван 32 80 80 80",
                " Петров Петр 71 91 89 100",
                "  Олег Тинькоф 1 15 60 30",
                "Воронов Максим 32 100 100 100",
                "Зеленская Екатерина 1 75 99 67",
                "  Столярова Анна 17 78 87 77",
                "         Логинова Полина 89 66 54 78",
                "Фейс Фейс 88 0 0 0",
                "Хоган Халк 52 0 0 0 ",
                "tampa tutttuu 88 2 5 9 ",
                "Ron Ilfon 42 0 0 0",
                "Ron Wilson 99 0 0 0"
        };

        Map<Integer, School> schoolMap = new HashMap<>();

        return Arrays.stream(data)
                .map(d -> {
                    String[] parts = d.trim().split(" ");
                    String surName = parts[0];
                    String name = parts[1];
                    int schoolNumber = Integer.parseInt(parts[2]);
                    int mathGrade = Integer.parseInt(parts[3]);
                    int rusGrade = Integer.parseInt(parts[4]);
                    int infGrade = Integer.parseInt(parts[5]);

                    School school = schoolMap.computeIfAbsent(schoolNumber, key -> new School(surName, name, schoolNumber, mathGrade, rusGrade, infGrade));
                    Student student = new Student(surName, name, mathGrade, rusGrade, infGrade);
                    if (!school.getStudents().contains(student)) {
                        school.add(student);
                    }
                    return school;
                })
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<School> getSchoolData() {
        return schools;
    }
}
