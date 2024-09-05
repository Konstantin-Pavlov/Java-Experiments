package org.example.stack;

import org.example.MyExceptions.CustomException;

import java.util.Arrays;


// доработать exception handling
public class StackWithoutCollections {
    private int min;
    private int max;
    private int size;
    private int[] data;

    public StackWithoutCollections() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.data = new int[0];
        this.size = 0;
    }

    public void push(int value) {
        max = Math.max(max, value);
        min = Math.min(min, value);
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = value;
        size++;
    }

    public int getMin() {
        try {
            if (size == 0) {
                throw new CustomException("can't get min element - stack is empty");
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        return Arrays.stream(data).min().orElse(Integer.MIN_VALUE);
    }

    public int getMax() {
        try {
            if (size == 0) {
                throw new CustomException("can't get min element - stack is empty");
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        return Arrays.stream(data).max().orElse(Integer.MAX_VALUE);
    }

    public int size() {
        return this.size;
    }

    public int pop() {
        try {
            if (size == 0) {
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                throw new CustomException("stack is empty");
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());

        }

        int lastElement = data[size - 1];
        size--;
        data = Arrays.copyOf(data, data.length - 1);
        return lastElement;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "StackWithoutCollections{" +
                "min=" + min +
                ", max=" + max +
                ", size=" + size +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
