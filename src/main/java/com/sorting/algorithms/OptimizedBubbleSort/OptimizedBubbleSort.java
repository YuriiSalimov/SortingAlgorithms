package com.sorting.algorithms.OptimizedBubbleSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * Bubble Sort   O(n^2)
 * *
 * Bubble Sort is the simplest sorting algorithm that works
 * by repeatedly swapping the adjacent elements if they are
 * in wrong order. The above function always runs O(n^2) time
 * even if the array is sorted. It can be optimized by stopping
 * the algorithm if inner loop didn't cause any swap.
 * *
 * http://www.geeksforgeeks.org/bubble-sort/
 */
public final class OptimizedBubbleSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    swapped = true;
                }
            }
            // IF no two elements were swapped
            // by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }
}
