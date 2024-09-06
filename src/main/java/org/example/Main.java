package org.example;

import org.example.CustomArrayList.CustomArrayList;
import utils.GetDuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        GetDuration.toSummer();

        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.iterator().forEachRemaining(System.out::println);
        System.out.println();

        list.forEach(System.out::println);
        System.out.println();

        for (Integer i : list) {
            System.out.println(i);
        }


    }

}
