package org.example.stack;

import MyExceptions.CustomException;

import java.util.Collections;
import java.util.NoSuchElementException;

public class EasyStack {
    private final java.util.List<Integer> list;
    private int min;
    private int max;

    public EasyStack() {
        this.list = new java.util.ArrayList<>();
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

    public void push(int value) {
        min = Math.min(min, value);
        max = Math.max(max, value);
        list.add(value);
    }

    public int getMin() {
        return Collections.min(list);
    }

    public int getMax() {
        return Collections.max(list);
    }

    public int size() {
        return list.size();
    }

    public int pop() throws CustomException {
        try {
            int lastElement = list.getLast();
            list.removeLast();
            return lastElement;
        } catch (NoSuchElementException e) {
            throw new CustomException("стек пуст");
        }

    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "list=" + list +
                '}';
    }
}
