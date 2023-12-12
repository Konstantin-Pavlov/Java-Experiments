package org.example;

import org.example.Array.Array;
import org.example.MyExceptions.CustomException;
import org.example.stack.EasyStack;
import org.example.stack.Stack;

public class Main {
    public static void main(String[] args) {

        Array array = new Array();
        array.add(2);
        array.add(3);
        array.add(5);
        array.add(-6);

        System.out.println(array);

//        EasyStack stack = new EasyStack();
//        stack.push(1);
//        stack.push(65);
//        stack.push(-564);
//        stack.push(52);
//
//        System.out.println(stack);
//
//        System.out.println(stack.getMax());
//        System.out.println(stack.getMin());
//
//        System.out.println(stack.size());
//
//        try {
//            stack.pop();
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(stack);
//
//        try {
//            stack.pop();
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(stack);
//
//        try {
//            stack.pop();
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            stack.pop();
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            stack.pop();
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
    }
}