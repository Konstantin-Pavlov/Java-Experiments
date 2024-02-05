package org.example.streamExamples;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MonthsEnumCollectToMap {
    public static void main(String[] args) {
        Map<Integer, String> monthsMap = Arrays.stream(Months.values())
                .collect(Collectors.toMap(Months::getMonthNumber, Months::getNameOfTheMonthInRussian));

        System.out.println(monthsMap.getOrDefault(new Scanner(System.in).nextInt(), "Ошибка"));
    }
}

enum Months {
    JANUARY(1, "Январь"),
    FEBRUARY(2, "Февраль"),
    MARCH(3, "Март"),
    APRIL(4, "Апрель"),
    MAY(5, "Май"),
    JUNE(6, "Июнь"),
    JULY(7, "Июль"),
    AUGUST(8, "Август"),
    SEPTEMBER(9, "Сентябрь"),
    OCTOBER(10, "Октябрь"),
    NOVEMBER(11, "Ноябрь"),
    DECEMBER(12, "Декабрь");

    private final int monthNumber;
    private final String nameOfTheMonthInRussian;

    Months(int monthNumber, String russianName) {
        this.monthNumber = monthNumber;
        this.nameOfTheMonthInRussian = russianName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getNameOfTheMonthInRussian() {
        return nameOfTheMonthInRussian;
    }

}
