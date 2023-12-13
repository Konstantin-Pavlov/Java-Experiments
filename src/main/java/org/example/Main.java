package org.example;

import org.example.stack.StackWithoutCollections;

public class Main {
    public static void main(String[] args) {

        StackWithoutCollections stack = new StackWithoutCollections();
        stack.push(1);
        stack.push(65);
        stack.push(-564);
        stack.push(52);

        System.out.println(stack);

        System.out.println(stack.getMax());

        for (int i = 0; i < 8; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack);
    }

}
