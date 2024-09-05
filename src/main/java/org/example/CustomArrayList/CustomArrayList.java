package org.example.CustomArrayList;

import org.example.sortings.CustomQuickSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A custom implementation of an ArrayList.
 *
 * <p>This implementation supports dynamic resizing and ensures that only elements
 * that implement the {@link Comparable} interface can be added to the list. The list
 * can be sorted using the natural ordering of its elements.</p>
 *
 * @param <T> the type of elements in this list, which must extend {@link Comparable}
 */
public class CustomArrayList<T extends Comparable<T>> {
    private Object[] data;
    private int size;

    /**
     * Constructs an empty list with an initial capacity of 8.
     */
    public CustomArrayList() {
        this.data = new Object[8];
        this.size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element the element to be added
     */
    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException (from indexCheck method call) if the index is out of range (index < 0 || index >= size)
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        indexCheck(index);
        return (T) data[index];
    }

    /**
     * Deletes the element at the specified index.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * The last element is set to null to avoid memory leaks.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException (from indexCheck method call) if the index is out of range (index < 0 || index >= size)
     */
    public void delete(int index) {
        indexCheck(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // Clear the last element
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Sorts the elements in this list in natural order.
     *
     * <p>This method uses the {@link CustomQuickSort} class to sort the elements
     * in the list. The elements must implement the {@link Comparable} interface
     * to be sorted. If the list contains fewer than two elements, the method
     * returns immediately.</p>
     *
     * @throws IllegalArgumentException if the elements are not comparable
     */
    @SuppressWarnings("unchecked")
    public void sort() {
        if (sizeLessThanTwo()) return;
        checkIfInstanceofComparable();

//        Arrays.sort(data, 0, size);

        T[] arrayToSort = (T[]) new Comparable[size];
        System.arraycopy(data, 0, arrayToSort, 0, size);
        CustomQuickSort.sort(arrayToSort);
        System.arraycopy(arrayToSort, 0, data, 0, size);
    }

    /**
     * Sorts the elements in this list using the specified comparator.
     *
     * <p>This method uses the {@link Arrays#sort(Object[], Comparator)} method to sort the elements
     * in the list based on the provided comparator. If the list contains fewer than two elements,
     * the method returns immediately.</p>
     *
     * @param comparator the comparator to determine the order of the list
     */
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> comparator) {
        if (sizeLessThanTwo()) return;
        checkIfInstanceofComparable();
        // Create a new array of type T[] using reflection and copy elements from data
        T[] arrayToSort =  (T[]) new Comparable[size];
        System.arraycopy(data, 0, arrayToSort, 0, size);
        Arrays.sort(arrayToSort, comparator);
        System.arraycopy(arrayToSort, 0, data, 0, size);
    }

    /**
     * Removes all elements from the collection.
     * Sets the size to 0 and nullifies all elements in the array to allow garbage collection.
     */
    public void clean() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    /**
     * Checks if type implements {@link Comparable} interface.
     */
    private void checkIfInstanceofComparable() {
        if (!(data[0] instanceof Comparable)) {
            throw new IllegalArgumentException("Elements are not comparable");
        }
    }

    /**
     * Checks if size of a list is less than two.
     */
    private boolean sizeLessThanTwo() {
        return size < 2;
    }

    /**
     * Checks if the given index is within the bounds of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    private void indexCheck(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("negative index");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds, " + size);
        }
    }

    /**
     * Resizes the internal array to accommodate more elements.
     */
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * Returns a string representation of this list.
     * The string representation consists of a list of the list's elements in the order they are returned by its iterator, enclosed in square brackets ("[]").
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        String fmt = "CustomArrayList [size=%d, data=%s]%n";
        return String.format(fmt, size, Arrays.stream(data)
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining(","))
        );
    }
}

