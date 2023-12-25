package org.example.thread;

import java.util.Random;

public class ThreadExample {
    public static void main(String[] args) {
        withMyThreadExample();

        withMyRunnableExample();

        System.out.println("main method");

    }

    private static void withMyRunnableExample() {
        Thread thread1 = new Thread(new Runner());
        Thread thread2 = new Thread(new Runner());
        thread1.start();
        thread2.start();
    }

    private static void withMyThreadExample() {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }

    public static void runningForLoop(String name) {
        for (int i = 0; i < 10; i++) {
            // 50% that thread sleeps
            if (new Random().nextBoolean()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(i + ": " + name);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread starts");
        ThreadExample.runningForLoop("MyThread");
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        System.out.println("Runner starts");
        ThreadExample.runningForLoop("Runner");
    }
}
