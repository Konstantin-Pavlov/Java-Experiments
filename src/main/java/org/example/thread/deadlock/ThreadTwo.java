package org.example.thread.deadlock;

public class ThreadTwo extends Thread {
    private final Object lock1;
    private final Object lock2;

    public ThreadTwo(final Object lock1, final Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("ThreadTwo, lock1");
            synchronized (lock2) {
                System.out.println("ThreadTwo, lock2");
            }
        }
    }
}
