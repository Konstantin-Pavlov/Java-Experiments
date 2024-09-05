package org.example.enum_with_methods;

import java.util.Arrays;

public class OperationRunner {
    public static void main(String[] args) {
        double a = 10;
        double b = 5;
        String fmt = "%s: %.2f%n";

        // Пример операций
        System.out.printf(fmt, Operation.ADD.getName(), Operation.ADD.calculate(a, b));         // 15.0
        System.out.printf(fmt, Operation.SUBTRACT.getName(), Operation.SUBTRACT.calculate(a, b)); // 5.0
        System.out.printf(fmt, Operation.MULTIPLY.getName(), Operation.MULTIPLY.calculate(a, b)); // 50.0
        System.out.printf(fmt, Operation.DIVIDE.getName(), Operation.DIVIDE.calculate(a, b));     // 2.0

        System.out.println();

        Arrays.stream(Operation.values())
                .forEach(
                        operation -> {
                            operation.describe();
                            System.out.printf(fmt + "%n", operation.getName(), operation.calculate(a, b));
                        }
                );

        // Попробуем деление на ноль
        try {
            System.out.println(Operation.DIVIDE.calculate(a, 0)); // ArithmeticException
        } catch (ArithmeticException e) {
            System.err.print("Error: " + e.getMessage());
        }
    }
}
