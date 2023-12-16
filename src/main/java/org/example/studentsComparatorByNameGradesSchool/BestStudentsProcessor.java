package org.example.studentsComparatorByNameGradesSchool;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestStudentsProcessor {
    private static final List<Student> students = CityGradesProcessor.getAllStudents();

    private static List<Student> getTheBestMathStudentsSorted() {
        //  todo : possible bug - if there's no students with grade 100 and above
        //   the max grade will be returned.
        //   Maybe it's correct.. depends on logic of the program


//        Explanation:
//
//        The students are first grouped by their math grade using Collectors.groupingBy(Student::getMathGrade).
//        The entrySet() method is used to get the set of entries from the grouping map.
//        The stream of entries is then sorted in descending order of keys (math grades) using max(Comparator.comparingInt(Map.Entry::getKey)).
//        The map(Map.Entry::getValue) operation is used to extract the values (lists of students) from the entry with the highest key.
//        If there are no students with a grade, Collections.emptyList() is returned.
//        The resulting list of students is then sorted by surname and name using sorted(Comparator.comparing(Student::getSurName).thenComparing(Student::getName)).
//        Finally, the sorted list is collected and returned.

//        This modified method will return a list containing all students with the maximum math grade.
//        If there are multiple students with the same maximum grade, they will be sorted by surname and name.

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
        // see explanation in getTheBestMathStudentsSorted method
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
        // see explanation in getTheBestMathStudentsSorted method
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
