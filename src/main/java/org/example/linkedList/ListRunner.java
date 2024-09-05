package org.example.linkedList;

import org.example.MyExceptions.CustomException;

import java.util.stream.IntStream;

public class ListRunner {
    public static void main(String[] args) throws CustomException {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        IntStream.range(0, 10).forEach(list::add);
        System.out.println(list);

        System.out.println(list.find(null));

//        list.add(null);
//        list.add(null);
//        list.add(null);
//        System.out.println(list);
//
//        list.add(65);
//
//        System.out.println(list);
//
//        IntStream.range(9, 16).forEach(element -> {
//            try {
//                System.out.println(list.get(element));
//            } catch (CustomException e) {
//                System.out.println(e.getMessage());
//            }
//        });


    }
}
