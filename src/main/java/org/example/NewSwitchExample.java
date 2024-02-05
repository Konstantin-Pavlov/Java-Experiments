package org.example;

import java.util.Scanner;

public class NewSwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = switch (num) {
            case 1 -> "Январь";
            case 2 -> "Февраль";
            case 3 -> "Март";
            case 4 -> "Апрель";
            case 5 -> "Май";
            case 6 -> "Июнь";
            case 7 -> "Июль";
            case 8 -> "Август";
            case 9 -> "Сентябрь";
            case 10 -> "Октябрь";
            case 11 -> "Ноябрь";
            case 12 -> "Декабрь";
            default -> "Ошибка";
        };
        System.out.println(str);

    }
}

class DayTypeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();

        String dayType;

        switch (dayNumber) {
            case 1, 2, 3, 4, 5 -> dayType = "Working day";
            case 6 -> dayType = "Saturday";
            case 7 -> dayType = "Sunday";
            default -> dayType = "ERROR";
        }

        System.out.println(dayType);

        scanner.close();
    }
}
