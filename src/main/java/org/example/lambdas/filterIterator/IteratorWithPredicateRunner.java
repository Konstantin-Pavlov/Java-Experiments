package org.example.lambdas.filterIterator;

import java.util.function.Predicate;

public class IteratorWithPredicateRunner {
    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] nums2 = new Integer[]{1, 3, 5};
        Predicate<Integer> predicate = x -> x % 2 == 0;
        IteratorWithPredicate<Integer> iterator1 = new IteratorWithPredicate<>(nums1, predicate);
        IteratorWithPredicate<Integer> iterator2 = new IteratorWithPredicate<>(nums2, predicate);

        iterator1.hasNext();
        iterator1.hasNext();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println(iterator2.hasNext());
        System.out.println(iterator2.next());
    }
}
