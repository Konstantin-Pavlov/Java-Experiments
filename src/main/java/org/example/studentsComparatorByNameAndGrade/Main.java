package org.example.studentsComparatorByNameAndGrade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("Mike", 5),
                new Student("Brus", 4),
                new Student("Saima", 3),
                new Student("Luke", 3),
                new Student("Jason", 3),
                new Student("Oleg", 5),
                new Student("Oleg", 4),
                new Student("Oleg", 3),
                new Student("Oleg", 2)
        };
//        Arrays.sort(students);
        // another way to sort
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed()
                .thenComparing(Student::getName));
        Arrays.stream(students).forEach(System.out::println);

//        withUserInput();

    }

    private static void withUserInput() {
        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
        Student[] students = IntStream.range(0, Integer.parseInt(scanner.nextLine()))
                .mapToObj(i -> {
                    String[] input = scanner.nextLine().split(" ");
                    String name = input[0];
                    int grade = Integer.parseInt(input[1]);
                    return new Student(name, grade);
                })
                .toArray(Student[]::new);
        Arrays.sort(students);
        Arrays.stream(students).forEach(System.out::println);
        scanner.close();
    }
}

