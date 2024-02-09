package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Пользователь вводит три строки, которые содержат части кодового слова.
Каждая вводимая строка может содержать пробелы и заканчивается символом перехода на новую строку ('\n').

Части кодового слова выделены внутри строки знаками ';'. Нужно соединить эти части в одну строку и вывести эту строку на консоль.

Замечание: поскольку предполагается, что кодовое слово будет как-то использовано в дальнейшем, недостаточно его просто вывести на консоль по частям.
Нужно именно сформировать его в виде одной строки, а затем уже выводить!

Sample Input:
To be or ;not; to be?
tes;ting; is good
I like ;ham; more then eggs
Sample Output:
nottingham

*/
public class CollectorsJoiningConcatSubstrings {
    private static final int LIMIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                Stream.generate(scanner::nextLine)   // Generate an infinite stream of lines from input
                        .map(line -> {
                            String extracted = ""; // Initialize an empty string to store the extracted substring
                            int startIndex = line.indexOf(';'); // Find the index of the first semicolon
                            int endIndex = line.lastIndexOf(';'); // Find the index of the last semicolon
                            if (startIndex != -1 && endIndex != -1 && startIndex != endIndex) { // Check if both semicolons are present and not at the same position
                                extracted = line.substring(startIndex + 1, endIndex); // Extract the substring between the semicolons
                            }
                            return extracted; // Return the extracted substring
                        })
                        .limit(LIMIT)  // Limit to 3 lines for demonstration
                        .collect(Collectors.joining()) // Concatenate the results
        );
        scanner.close();
    }
}
