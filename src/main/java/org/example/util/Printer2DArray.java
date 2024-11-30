package org.example.util;

import java.util.Arrays;

public class Printer2DArray {
    private Printer2DArray() {
    }


    // Generic method accepting 2D arrays of non-primitive values
    public static <T> void print(T[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });
        System.out.println();
    }


    // Method for byte 2D arrays
    public static void print(byte[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    for (byte b : row) {
                        System.out.print(b + " ");
                    }
                    System.out.println();
                });
        System.out.println();
    }

    // Method for int 2D arrays
    public static void print(int[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });
        System.out.println();
    }

    // Method for long 2D arrays
    public static void print(long[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });
        System.out.println();
    }

    // Method for float 2D arrays
    public static void print(float[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    for (float f : row) {
                        System.out.print(f + " ");
                    }
                    System.out.println();
                });
        System.out.println();
    }

    // Method for double 2D arrays
    public static void print(double[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });
        System.out.println();
    }

    // Method for char 2D arrays
    public static void print(char[][] arr) {
        Arrays.stream(arr)
                .forEach(row -> {
                    for (char c : row) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                });
        System.out.println();
    }
}
