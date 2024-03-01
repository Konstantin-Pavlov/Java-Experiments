package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 11;
    private static final int LIMIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger sum = new AtomicInteger();
        scanner.nextLine().chars().filter(Character::isDigit).forEach(value -> {
            sum.addAndGet(value - '0');
            stringBuilder.append(value - '0').append("+");
        });
        if (stringBuilder.isEmpty()) {
            System.out.println("ERROR");
            return;
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "=" + sum);
        System.out.println(stringBuilder);
        scanner.close();
    }


    private static void moveWordInsideArray(String[] words, int fromIndex, int toIndex) {
        String wordToInsert = words[fromIndex];
        if (fromIndex < toIndex) {
            for (int i = fromIndex; i < toIndex; i++) {
                words[i] = words[i + 1];
            }
        } else {
            for (int i = fromIndex; i > toIndex; i--) {
                words[i] = words[i - 1];
            }
        }
        words[toIndex] = wordToInsert;
    }

    private static int getIndexOfWordStartingWithTheLetter(String[] words, String letter, int startIndex) {
        return IntStream.range(startIndex, words.length)
                .filter(index -> words[index].startsWith(letter))
                .findFirst()
                .orElse(-1);

    }

    private static void print1DArray(String[] words) {
        Arrays.stream(words).forEach(word -> System.out.print(word + " "));
    }

}
