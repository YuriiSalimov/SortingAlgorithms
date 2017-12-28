package com.sorting.algorithms.SelectionSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * Selection Sort   O(n^2)
 *
 * The selection sort algorithm sorts an array by repeatedly finding
 * the minimum element (considering ascending order) from unsorted part
 * and putting it at the beginning.
 * The algorithm maintains two subarrays in a given array.
 * *
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 * *
 * In every iteration of selection sort, the minimum element
 * (considering ascending order) from the unsorted subarray is picked
 * and moved to the sorted subarray.
 * *
 * Following example explains the above steps:
 * arr[] = 64 25 12 22 11
 * *
 * Find the minimum element in arr[0...4]
 * and place it at beginning
 * 11 25 12 22 64
 * *
 * Find the minimum element in arr[1...4]
 * and place it at beginning of arr[1...4]
 * 11 12 25 22 64
 * *
 * Find the minimum element in arr[2...4]
 * and place it at beginning of arr[2...4]
 * 11 12 22 25 64
 * *
 * Find the minimum element in arr[3...4]
 * and place it at beginning of arr[3...4]
 * 11 12 22 25 64
 * *
 * Time Complexity: O(n2) as there are two nested loops.
 * *
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n) 
 * swaps and can be useful when memory write is a costly operation.
 * *
 * http://www.geeksforgeeks.org/selection-sort/
 */
public final class SelectionSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // Swap the found minimum element
            // with the first element
            swap(array, min, i);
        }
    }
}
