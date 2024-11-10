package org.example.thread.deadlock;

/**
 * in case of deadlock, how to track it:
 * <br>
 * jps -> get process pid
 * <br>
 * jstack [process pid]
 */

public class DeadLockRunner {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        ThreadOne threadOne = new ThreadOne(lock1, lock2);
        ThreadTwo threadTwo = new ThreadTwo(lock1, lock2);

        threadOne.start();
        threadTwo.start();

    }
}
