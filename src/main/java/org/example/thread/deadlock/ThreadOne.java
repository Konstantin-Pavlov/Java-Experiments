package org.example.thread.deadlock;

public class ThreadOne extends Thread {
    private final Object lock1;
    private final Object lock2;

    public ThreadOne(final Object lock1, final Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("ThreadOne, lock2");
            synchronized (lock1) {
                System.out.println("ThreadOne, lock1");
            }
        }
    }
}
