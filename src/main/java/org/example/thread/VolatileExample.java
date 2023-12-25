package org.example.thread;

import java.util.Scanner;

public class VolatileExample {
    public static void main(String[] args) {
        NewThread thread = new NewThread();
        thread.start();

        // waits for user to press enter, then goes to the next line and program finishes
        new Scanner(System.in).nextLine();
        thread.shutDown();
    }
}

class NewThread extends Thread {
    // volatile - not need to cash this variable - it may change
    // a situation when one thread updated a variable and another reads this variable
    // threads share one variable (this case - VolatileExample and NewThread threads)
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("NewThread running");
        }
    }

    public void shutDown() {
        this.running = false;
    }
}
