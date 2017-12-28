package com.sorting.algorithms.QuickSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * QuickSort O(n*log(n))
 * *
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array around
 * the picked pivot. There are many different versions of quickSort
 * that pick pivot in different ways.
 * *
 * 1. Always pick first element as pivot.
 * 2. Always pick last element as pivot (implemented below)
 * 3. Pick a random element as pivot.
 * 4. Pick median as pivot.
 * *
 * The key process in quickSort is partition(). Target of partitions is,
 * given an array and an element x of array as pivot, put x at its correct
 * position in sorted array and put all smaller elements (smaller than x)
 * before x, and put all greater elements (greater than x) after x.
 * All this should be done in linear time.
 * *
 * Pseudo Code for recursive QuickSort function :
 * low  --> Starting index,  high  --> Ending index
 * <code>
 * quickSort(arr[], low, high) {
 * if (low < high) {
 * pi is partitioning index, arr[pi] is now
 * at right place
 * pi = partition(arr, low, high);
 * quickSort(arr, low, pi - 1);  // Before pi
 * quickSort(arr, pi + 1, high); // After pi
 * }
 * }
 * </code>
 * *
 * Partition Algorithm
 * There can be many ways to do partition, following pseudo code adopts
 * the method given in CLRS book. The logic is simple, we start from the
 * leftmost element and keep track of index of smaller (or equal to) elements
 * as i. While traversing, if we find a smaller element, we swap current
 * element with arr[i]. Otherwise we ignore current element.
 * *
 * Pseudo code for partition()
 * This function takes last element as pivot, places
 * the pivot element at its correct position in sorted
 * array, and places all smaller (smaller than pivot)
 * to left of pivot and all greater elements to right
 * of pivot
 * <code>
 * partition (arr[], low, high) {
 * // pivot (Element to be placed at right position)
 * pivot = arr[high];
 * i = (low - 1)  // Index of smaller element
 * for (j = low; j <= high- 1; j++) {
 * // If current element is smaller than or
 * // equal to pivot
 * if (arr[j] <= pivot) {
 * i++;    // increment index of smaller element
 * swap arr[i] and arr[j]
 * }
 * }
 * swap arr[i + 1] and arr[high])
 * return (i + 1)
 * }
 * </code>
 * <p>
 * http://www.geeksforgeeks.org/quick-sort/
 */
public final class QuickSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    /**
     * The main function that implements QuickSort()
     * array[] --> Array to be sorted,
     * low  --> Starting index,
     * high  --> Ending index
     */
    private void quickSort(
            final int[] array,
            final int low,
            final int high
    ) {
        if (low < high) {
            /* pi is partitioning index, array[pi] is
              now at right place */
            final int pi = partition(array, low, high);
            // Recursively sort elements before
            // partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * This function takes last element as pivot,
     * places the pivot element at its correct
     * position in sorted array, and places all
     * smaller (smaller than pivot) to left of
     * pivot and all greater elements to right
     * of pivot
     */
    private int partition(
            final int[] array,
            final int low,
            final int high
    ) {
        final int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;
                // swap array[i] and array[j]
                swap(array, i, j);
            }
        }
        // swap array[i+1] and array[high] (or pivot)
        swap(array, i + 1, high);
        return i + 1;
    }
}
