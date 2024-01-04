package org.example.lambdas;

public class LambdasAsAResultOfMethods {
    public static void main(String[] args) {
        Operation func = action(1);
        double a = func.execute(6, 5);
        System.out.println(a); // 11.0

        double b = action(2).execute(8, 2);
        System.out.println(b); // 6.0

        System.out.println(action(3).execute(9, 5)); // 45.0

        System.out.println(action(4).execute(12, 15)); // 0.8
    }

    private static Operation action(int number) {
        return switch (number) {
            case 1 -> Double::sum;
            case 2 -> (x, y) -> x - y;
            case 3 -> (x, y) -> x * y;
            case 4 -> (x, y) -> {
                if (y == 0) {
                    return 0;
                }
                return x / y;
            };
            default -> (x, y) -> 0;
        };
    }
}

interface Operation {
    double execute(double x, double y) throws ArithmeticException;
}


