package org.example.fuctionalInterfaceExample.refToConstructor;

public class MyClass {
    private int n;

    public MyClass(int n) {
        this.n = n;
    }

    void show() {
        System.out.println("n: " + n);
    }
}
