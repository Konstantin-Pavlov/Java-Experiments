package org.example.studentsComparatorByNameGradesSchool;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class App {
    public static void main(String[] args) {
//        List<School> schools = DataReader.getSchoolData();
//        schools.forEach(System.out::println);
//        schools.forEach(school -> System.out.println(school.getMathAverageGrade()));
        CityGradesProcessor.showMessage();
        System.out.println("Отчет по школам:");
        SchoolsSorter.printSortedSchools();
        BestStudentsProcessor.printTheBestMathStudents();
        BestStudentsProcessor.printTheBestRusStudents();
        BestStudentsProcessor.printTheBestInfStudents();

//        DataReader.getSchoolData().forEach(System.out::println);


        //todo: распределить по классам

    }
}

class DataReader {
    //    private static final List<School> schools = readSchoolData();
    private static final List<School> schools = readUserInput();

    private DataReader() {
    }

    private static List<School> readUserInput() {
        String[] data = getUserInput();

//        Arrays.stream(data).forEach(System.out::println);

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
        };
//        return Arrays.stream(data).map(d -> new School(d.trim().split(" "))).toList();
//        "Фейс Фейс 88 0 0 0",
//                "Хоган Халк 52 0 0 0 ",
//                "tampa tutttuu 88 2 5 9 "
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
        return "Student{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                ", rusGrade=" + rusGrade +
                ", infGrade=" + infGrade +
                '}';
    }
}

class School {
    private List<Student> students = new ArrayList<>();
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

class CityGradesProcessor {
    private final static List<School> schools = DataReader.getSchoolData();

    private CityGradesProcessor() {
    }

    private static double getCityMathAverageGrade() {
//        return schools.stream().mapToDouble(School::getMathAverageGrade).average().orElse(0.0);
        return getAllStudents().stream().mapToDouble(Student::getMathGrade).average().orElse(0.0);
    }

    private static double getCityRusAverageGrade() {
//        return schools.stream().mapToDouble(School::getRusAverageGrade).average().orElse(0.0);
        return getAllStudents().stream().mapToDouble(Student::getRusGrade).average().orElse(0.0);

    }

    private static double getCityInfAverageGrade() {
//        return schools.stream().mapToDouble(School::getInfAverageGrade).average().orElse(0.0);
        return getAllStudents().stream().mapToDouble(Student::getInfGrade).average().orElse(0.0);

    }

    private static double getCityAverageGrade() {
        return DoubleStream.of(getCityInfAverageGrade(), getCityRusAverageGrade(), getCityMathAverageGrade()).average().orElse(0.0);
    }

    public static void showMessage() {
        //Отчет по городу: математика - 72.1, русский язык - 81.3, инфрматика - 76.0, общий средний балл - 76.5
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

class BestStudentsProcessor {
    private static final List<Student> students = CityGradesProcessor.getAllStudents();

    private static List<Student> getTheBestMathStudentsSorted() {
//        return students.stream().filter(student -> student.getMathGrade() >= 100)
//                .sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName))
//                .collect(Collectors.toList());
        return students.stream()
                .collect(Collectors.groupingBy(Student::getMathGrade))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList())
                .stream()
                .sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName))
                .collect(Collectors.toList());
    }

    private static List<Student> getTheBestRusStudentsSorted() {
//        return students.stream().filter(student -> student.getRusGrade() >= 100)
//                .sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName))
//                .collect(Collectors.toList());

        return students.stream()
                .collect(Collectors.groupingBy(Student::getRusGrade))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList())
                .stream()
                .sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName))
                .collect(Collectors.toList());
    }

    private static List<Student> getTheBestInfStudentsSorted() {
//        return students.stream()
//                .filter(student -> student.getInfGrade() >= 100)
//                .sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName))
//                .collect(Collectors.toList());

        return students.stream()
                .collect(Collectors.groupingBy(Student::getInfGrade))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList())
                .stream()
                .sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static void printTheBestMathStudents() {
        List<Student> mathStudents = getTheBestMathStudentsSorted();
        if (mathStudents.isEmpty()) {
            return;
        }
        mathStudents.forEach(
                student -> System.out.printf(
                        "Лучший результат по математике - %s %s - %d%n",
                        student.getSurName(), student.getName(), student.getMathGrade()
                )
        );
    }

    public static void printTheBestRusStudents() {
        List<Student> rusStudents = getTheBestRusStudentsSorted();
        if (rusStudents.isEmpty()) {
            return;
        }
        rusStudents.forEach(
                student -> System.out.printf(
                        "Лучший результат по русскому языку - %s %s - %d%n",
                        student.getSurName(), student.getName(), student.getRusGrade()
                )
        );
    }

    public static void printTheBestInfStudents() {
        List<Student> infStudents = getTheBestInfStudentsSorted();
        if (infStudents.isEmpty()) {
            return;
        }
        infStudents.forEach(
                student -> System.out.printf(
                        "Лучший результат по информатике  - %s %s - %d%n",
                        student.getSurName(), student.getName(), student.getInfGrade()
                )
        );
    }

}

class SchoolsSorter {
    private static final List<School> schools = DataReader.getSchoolData();

    private SchoolsSorter() {
    }

    private static List<School> getSortedSchools() {
        List<School> sortedSchools = new ArrayList<>(schools);
        sortedSchools.sort(Comparator.comparing(School::getOverallGPA).reversed()
                .thenComparing(School::getMathAverageGrade).reversed()
                .thenComparing(School::getRusAverageGrade).reversed()
                .thenComparing(School::getInfAverageGrade).reversed()
                .thenComparing(School::getSchoolNumber).reversed()
        );
        return sortedSchools;
    }

    public static void printSortedSchools() {
        getSortedSchools().forEach(System.out::println);
    }


}