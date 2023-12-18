package org.example.linkedList;

import MyExceptions.CustomException;

import java.util.stream.IntStream;

public class ListRunner {
    public static void main(String[] args) throws CustomException {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        IntStream.range(0, 10).forEach(list::add);
        System.out.println(list);
    }
}
