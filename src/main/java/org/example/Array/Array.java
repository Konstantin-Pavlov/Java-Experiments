package org.example.Array;

import java.util.Arrays;

public class Array {

    private int size;
    private int[] data;

    public Array() {
        this.data = new int[0];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int[] getData() {
        return data;
    }

    public void add(int element) {
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = element;
        size += 1;
    }

    @Override
    public String toString() {
        return "Array [size=" + size + ", data=" + Arrays.toString(data) + "]";
    }
}
