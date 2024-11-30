package org.example.util;

import java.util.Arrays;

public class Printer1DArray {
    private Printer1DArray() {
    }

    public static void print1DArray(String[] words) {
        Arrays.stream(words).forEach(word -> System.out.print(word + " "));
    }
}
