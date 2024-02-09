package org.example.streamExamples;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

//todo - try sorting?

/*
Пользователь вводит строку из слов, разделенных одним пробелом.
Переставить слова местами так, чтобы каждое следующее слово начиналось с буквы,
которой заканчивается предыдущее слово (существование такого слова в тестах гарантируется).

Sample Input:
trolli emodji road tiger dog insert game
Sample Output:
trolli insert tiger road dog game emodj

i*/

public class LastLetterEqualsFirstLetter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = new Scanner(System.in).nextLine().split(" ");

        IntStream.range(0, words.length - 1).forEach(currentIndex -> {
            String currentWord = words[currentIndex];
            int fromIndex = getIndexOfWordStartingWithTheLetter(words, currentWord.substring(currentWord.length() - 1), currentIndex);
            moveWordInsideArray(words, fromIndex, currentIndex + 1);
        });

        print1DArray(words);

        Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .map(word -> word.contains("z") ? "ERROR" : word)
                .forEach(word -> System.out.print(word + " "));
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
