package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class InitializeMapWithMultipleValuesExample {
    public static void main(String[] args) {
        Map<String, String> dayTranslations = createDayTranslations();
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                Objects.requireNonNullElse(
                        dayTranslations.get(scanner.nextLine().toLowerCase()), "ERROR")
        );
        scanner.close();
    }

    public static Map<String, String> createDayTranslations() {
        return Map.of(
                "понедельник", "Monday",
                "вторник", "Tuesday",
                "среда", "Wednesday",
                "четверг", "Thursday",
                "пятница", "Friday",
                "суббота", "Saturday",
                "воскресенье", "Sunday"
        );
    }
}
