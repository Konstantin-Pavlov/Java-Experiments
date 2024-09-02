package org.example.streamExamples;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

public class IntStreamGenerateRandom {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int n = 10;
        int seed = 42;
        Random random = new Random(seed);
        int[] nums = IntStream
                .generate(() -> random.nextInt(-5, 6))
                .limit(n)
                .toArray();

        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.printf("%n%d %.1f",
                Arrays.stream(nums).filter(num -> num >= 0).sum(),
                Arrays.stream(nums).mapToDouble(x -> x).filter(num -> num < 0).reduce((x, y) -> x * y).orElse(0.0)
        );
    }
}
