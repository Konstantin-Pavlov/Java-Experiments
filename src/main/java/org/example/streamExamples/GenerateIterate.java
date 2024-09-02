package org.example.streamExamples;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class GenerateIterate {
    public static void main(String[] args) {
        Random random = new Random();

        Stream<Integer> randNums = Stream.generate(() -> random.nextInt(25)).limit(25);
        Stream<Integer> nums = Stream.iterate(0, x -> x + 1).limit(10);

        randNums.forEach(n -> System.out.print(n + " "));
        System.out.println();
        nums.forEach(n -> System.out.print(n + " "));

        System.out.println();

        List<String> words = List.of("wew", "like", "woof", "wow", "lol");
        List<String> startsWithW = words.stream().filter(w -> w.startsWith("w")).toList();
        startsWithW.forEach(n -> System.out.print(n + " "));

    }
}
