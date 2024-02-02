package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.Stream;

/*
A haiku is a traditional cornerstone of Japanese poetry with no set rhyme scheme,
but a specific shape: three lines composed of five syllables in the first line,
seven in the second line, and five in the third line.
Occasionally, some traditional Japanese haiku won’t fit this format because the syllables change when they’re translated into English;
but when you’re writing your own haiku poem in your native language, you should try to adhere to this structure.\n
 */

public class WordOccurrences {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        System.out.println(Stream.generate(scanner::nextLine).limit(5) // limit(Long.parseLong(scanner.nextLine()))
                .filter(s -> s.toLowerCase().contains("japanese")).count());
    }
}
