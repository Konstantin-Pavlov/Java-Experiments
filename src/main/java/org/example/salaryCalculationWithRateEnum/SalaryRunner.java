package org.example.salaryCalculationWithRateEnum;

import java.util.Scanner;

public class SalaryRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = scanner.nextInt();
        double tariff = scanner.nextDouble();


        try {
            System.out.printf("%.2f", Rate.calculateSalary(hours, tariff));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
