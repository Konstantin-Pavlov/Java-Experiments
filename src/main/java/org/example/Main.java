package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        log.info("Start");
        log.warn("warn");
        log.error("error");
        log.trace("trace");
        log.debug("debug");

        List<Integer> list = new ArrayList<>();
        Stream.of(1, 2, 3).forEach(list::add);
        System.out.println(list);
//        List<String> names = List.of("Alice", "Bob", "Alice", "Charlie");
//        Map<String, Integer> namesMap = new LinkedHashMap<>();
//        names.forEach(name -> namesMap.compute(name, (word, freq) -> freq == null ? 1 : freq + 1));
//        namesMap.entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1)
//                .findFirst()
//                .ifPresentOrElse(
//                        entry -> System.out.println(entry.getKey()),
//                        () -> System.out.println("no unique name found")
//                );

//        names.forEach(name -> namesMap.put(name, !namesMap.containsKey(name)));
//        System.out.println(namesMap);
//        String firstUniqueName = names
//                .stream()
//                .filter(namesMap::get)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("no unique name found"));
//        System.out.println(firstUniqueName);

//        int availableProcessors = Runtime.getRuntime().availableProcessors();
//        System.out.println("Available processors (cores): " + availableProcessors);
//
//        // Create a thread pool with a number of threads equal to the number of available processors
//        try (ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);) {
//            // Submit tasks to the executor service
//            for (int i = 0; i < 10; i++) {
//                executorService.submit(new Task());
//            }
//
//            // Shutdown the executor service
//            executorService.shutdown();
//        }

//        GetDuration.toSummer();

//        CustomArrayList<Integer> list = new CustomArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.iterator().forEachRemaining(System.out::println);
//        System.out.println();
//
//        list.forEach(System.out::println);
//        System.out.println();
//
//        for (Integer i : list) {
//            System.out.println(i);
//        }

    }


}


class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task executed by: " + Thread.currentThread().getName());
    }
}
