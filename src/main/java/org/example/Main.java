package org.example;

import org.example.CustomArrayList.CustomArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {




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
