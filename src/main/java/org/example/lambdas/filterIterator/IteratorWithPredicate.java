package org.example.lambdas.filterIterator;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class IteratorWithPredicate<T> {
    private final T[] collection;
    private final Predicate<T> predicate;
    private int currentIndex;

    public IteratorWithPredicate(T[] collection, Predicate<T> predicate) {
        this.collection = collection;
        this.predicate = predicate;
        this.currentIndex = 0;
    }

    //update current index
    public boolean hasNext() {
        while (currentIndex < collection.length) {
            if (checkCondition(collection[currentIndex])) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    // without while
    public T next() {
        if (hasNext()) {
            return collection[currentIndex++];
        }
        throw new NoSuchElementException("There are no elements matching the predicate");

    }

    private boolean checkCondition(T element) {
        return predicate.test(element);
    }
}
