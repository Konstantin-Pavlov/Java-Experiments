package org.example.thread;

import org.example.util.ConsoleColors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int taskCount = 8;
        submitTaskInto(pool, taskCount);
        pool.shutdown();
        measure(pool);
        System.out.println("*".repeat(42));
    }

    static void submitTaskInto(ExecutorService pool, int taskCount) {
        System.out.println(ConsoleColors.ANSI_GREEN_BACKGROUND + "creating tasks" + ConsoleColors.RESET);
        IntStream.rangeClosed(1, taskCount)
                .mapToObj(ExecutorServiceExample::makeTask)
                .forEach(pool::submit);
    }

    static Runnable makeTask(int taskId) {
        int temp = new Random().nextInt(20000) + 10000;
        int taskTime = (int) TimeUnit.MILLISECONDS.toSeconds(temp);
        return () -> heavyTask(taskId, taskTime);
    }

    static void heavyTask(int taskId, int taskTime) {
        System.out.printf(ConsoleColors.ANSI_BLUE + "Task %d will take %d seconds%n" + ConsoleColors.RESET, taskId, taskTime);
        try {
            Thread.sleep(taskTime * 1000L);
            System.out.printf(ConsoleColors.GREEN + "Task %d finished in %d seconds%n" + ConsoleColors.RESET, taskId, taskTime);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    static void measure(ExecutorService pool) {
        long start = System.nanoTime();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        long delta = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - start);
        System.out.printf(ConsoleColors.PURPLE_BOLD_BRIGHT + "%nProgram execution took %d seconds%n" + ConsoleColors.RESET, delta);
    }
}
