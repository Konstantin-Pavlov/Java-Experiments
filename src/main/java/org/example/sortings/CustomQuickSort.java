package org.example.sortings;

/**
 * A utility class that provides a generic implementation of the QuickSort algorithm.
 */
public class CustomQuickSort {

    /**
     * Private constructor to prevent instantiation.
     */
    private CustomQuickSort() {
    }

    /**
     * Sorts the specified array using the QuickSort algorithm.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must extend Comparable<T>
     *
     * @throws IllegalArgumentException if the elements are not comparable
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        if (!(array[0] instanceof Comparable)) {
            throw new IllegalArgumentException("Elements are not comparable");
        }
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Recursively sorts the subarrays before and after the partition index.
     *
     * @param array the array to be sorted
     * @param low   the starting index of the subarray to be sorted
     * @param high  the ending index of the subarray to be sorted
     * @param <T>   the type of elements in the array, which must extend Comparable<T>
     */
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    /**
     * Partitions the array around the pivot element.
     *
     * @param array the array to be partitioned
     * @param low   the starting index of the subarray to be partitioned
     * @param high  the ending index of the subarray to be partitioned
     * @param <T>   the type of elements in the array, which must extend Comparable<T>
     * @return the index of the pivot element after partitioning
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps the elements at the specified positions in the array.
     *
     * @param array the array in which to swap elements
     * @param i     the index of one element to be swapped
     * @param j     the index of the other element to be swapped
     * @param <T>   the type of elements in the array, which must extend Comparable<T>
     */
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}