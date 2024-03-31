package org.example.thread.SumCalculation;

import lombok.SneakyThrows;

public class SumUpToIntegerMaxNumber {
    private final long startRange;
    private final long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpToIntegerMaxNumber(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    public static void oneThread() {
        long start = System.currentTimeMillis();
        SumUpToIntegerMaxNumber s = new SumUpToIntegerMaxNumber(1, MAX_NUM);
        s.add();

        long end = System.currentTimeMillis();
        System.out.printf("%-20s %d and it took: %.2f seconds%n", "one thread sum:", s.counter, (end - start) / 1000.0);
    }

    @SneakyThrows
    public static void twoThreads() {
        long start = System.currentTimeMillis();
        SumUpToIntegerMaxNumber s1 = new SumUpToIntegerMaxNumber(1, MAX_NUM / 2);
        SumUpToIntegerMaxNumber s2 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;

        long end = System.currentTimeMillis();
        System.out.printf("%-20s %d and it took: %.2f seconds%n", "two threads sum:", finalCount, (end - start) / 1000.0);
    }

    @SneakyThrows
    public static void threeThreads() {
        long start = System.currentTimeMillis();
        SumUpToIntegerMaxNumber s1 = new SumUpToIntegerMaxNumber(1, MAX_NUM / 3);
        SumUpToIntegerMaxNumber s2 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 3), (MAX_NUM / 3) * 2);
        SumUpToIntegerMaxNumber s3 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 3) * 2, MAX_NUM);

        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);
        Thread t3 = new Thread(s3::add);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long finalCount = s1.counter + s2.counter + s3.counter;

        long end = System.currentTimeMillis();
        System.out.printf("%-20s %d and it took: %.2f seconds%n", "three threads sum:", finalCount, (end - start) / 1000.0);
    }

    @SneakyThrows
    public static void fourThreads() {
        long start = System.currentTimeMillis();
        SumUpToIntegerMaxNumber s1 = new SumUpToIntegerMaxNumber(1, MAX_NUM / 4);
        SumUpToIntegerMaxNumber s2 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 4), (MAX_NUM / 4) * 2);
        SumUpToIntegerMaxNumber s3 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 4) * 2, (MAX_NUM / 4) * 3);
        SumUpToIntegerMaxNumber s4 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 4) * 3, MAX_NUM);

        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);
        Thread t3 = new Thread(s3::add);
        Thread t4 = new Thread(s4::add);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long finalCount = s1.counter + s2.counter + s3.counter + s4.counter;

        long end = System.currentTimeMillis();
        System.out.printf("%-20s %d and it took: %.2f seconds%n", "four threads sum:", finalCount, (end - start) / 1000.0);
    }

    @SneakyThrows
    public static void fiveThreads() {
        long start = System.currentTimeMillis();
        SumUpToIntegerMaxNumber s1 = new SumUpToIntegerMaxNumber(1, MAX_NUM / 5);
        SumUpToIntegerMaxNumber s2 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 5), (MAX_NUM / 5) * 2);
        SumUpToIntegerMaxNumber s3 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 5) * 2, (MAX_NUM / 5) * 3);
        SumUpToIntegerMaxNumber s4 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 5) * 3, (MAX_NUM / 5) * 4);
        SumUpToIntegerMaxNumber s5 = new SumUpToIntegerMaxNumber(1 + (MAX_NUM / 5) * 4, MAX_NUM);

        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);
        Thread t3 = new Thread(s3::add);
        Thread t4 = new Thread(s4::add);
        Thread t5 = new Thread(s5::add);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long finalCount = s1.counter + s2.counter + s3.counter + s4.counter + s5.counter;

        long end = System.currentTimeMillis();
        System.out.printf("%-20s %d and it took: %.2f seconds%n", "five threads sum:", finalCount, (end - start) / 1000.0);
    }

    public static void runTests() {
        oneThread();
        twoThreads();
        threeThreads();
        fourThreads();
        fiveThreads();
    }
}
