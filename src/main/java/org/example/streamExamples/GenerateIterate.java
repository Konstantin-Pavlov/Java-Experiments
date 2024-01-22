package org.example.streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        Optional[] startsWithW = words.stream().filter(w -> w.startsWith("w")).map(Optional::of).toArray(Optional[]::new);
        Arrays.stream(startsWithW).forEach(n -> {
            if(n.isPresent()){
                System.out.print(n.get() + " ");
            }
//            System.out.print(n.orElse("not present") + " ");
        });

    }
}
