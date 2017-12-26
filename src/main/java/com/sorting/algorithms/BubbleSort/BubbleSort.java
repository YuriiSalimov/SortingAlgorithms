package com.sorting.algorithms.BubbleSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * Bubble Sort   O(n^2)
 * *
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in wrong order.
 * *
 * Example:
 * First Pass:
 * ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
 * ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
 * ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
 * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ),
 * Now, since these elements are already in order (8 > 5), algorithm does not swap them.
 * *
 * Second Pass:
 * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
 * ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
 * Now, the array is already sorted, but our algorithm does not know if it is completed.
 * The algorithm needs one whole pass without any swap to know it is sorted.
 * *
 * Third Pass:
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * *
 * Worst and Average Case Time Complexity: O(n*n).
 * Worst case occurs when array is reverse sorted.
 * *
 * Best Case Time Complexity: O(n).
 * Best case occurs when array is already sorted.
 * *
 * Auxiliary Space: O(1)
 * *
 * Boundary Cases:
 * Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * *
 * Sorting In Place: Yes
 * *
 * Stable: Yes
 * *
 * http://www.geeksforgeeks.org/bubble-sort/
 */
public final class BubbleSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }
}
