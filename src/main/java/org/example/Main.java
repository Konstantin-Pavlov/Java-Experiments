package org.example;

import MyExceptions.CustomException;
import org.example.stack.StackWithoutCollections;

public class Main {
    public static void main(String[] args) {

        StackWithoutCollections stack = new StackWithoutCollections();
        stack.push(1);
        stack.push(65);
        stack.push(-564);
        stack.push(52);

        System.out.println(stack);

//        try {
//            System.out.println(stack.getMax());
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            System.out.println(stack.getMin());
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(stack.size());
//
        for (int i = 0; i < 8; i++) {
            try {
                System.out.println(stack.pop());
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(stack);
        }


    }
}