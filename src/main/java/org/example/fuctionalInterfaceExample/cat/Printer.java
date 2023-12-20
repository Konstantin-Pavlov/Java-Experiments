package org.example.fuctionalInterfaceExample.cat;


// код можно менять только в особо отмеченном месте этого файла,
// так же возможно вам понадобится добавить что-то в
// блок import и поменять имя пакета
// в остальных местах этого файла код менять не разрешается.

import java.util.List;
import java.util.stream.IntStream;

public final class Printer {
    private static void printHeader() {
        System.out.printf("%1$10.10s | %1$3.3s | %1$-10.10s | %1$-10.10s |%n", "--------------");
        System.out.printf("%10.10s | %3.3s | %-10.10s | %-10.10s |%n", "Name", "Age", "Breed", "Color");
        System.out.printf("%1$10.10s | %1$3.3s | %1$-10.10s | %1$-10.10s |%n", "--------------");
    }

    private static void printCat(Cat cat) {
        System.out.printf("%10.10s | %3.3s | %-10.10s | %-10.10s |%n", cat.getName(), cat.getAge(),
                cat.getBreed(), cat.getColor());
    }

    public static void print(List<Cat> cats) {
        printHeader();
        cats.forEach(Printer::printCat);
        System.out.println();
    }

    public static void drawLine() {
        System.out.println();
        IntStream.range(0, 42).forEach(e -> System.out.print("#"));
        System.out.println("\n");
    }
}

