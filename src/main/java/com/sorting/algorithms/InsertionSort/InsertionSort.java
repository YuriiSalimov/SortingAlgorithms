package com.sorting.algorithms.InsertionSort;

import com.sorting.algorithms.Sort;

/**
 * Insertion Sort   O(n^2)
 * *
 * Insertion sort is a simple sorting algorithm that works
 * the way we sort playing cards in our hands.
 * *
 * Algorithm
 * Sort an arr[] of size n
 * insertionSort(arr, n)
 * Loop from i = 1 to n-1.
 * a) Pick element arr[i] and insert it into
 * sorted sequence arr[0…i-1]
 * *
 * Example:
 * 12, 11, 13, 5, 6
 * Let us loop for i = 1 (second element of the array) to 5 (Size of input array)
 * *
 * i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
 * 11, 12, 13, 5, 6
 * *
 * i = 2. 13 will remain at its position as all elements
 * in A[0..I-1] are smaller than 13
 * 11, 12, 13, 5, 6
 * *
 * i = 3. 5 will move to the beginning and all other elements
 * from 11 to 13 will move one position ahead of their current position.
 * 5, 11, 12, 13, 6
 * *
 * i = 4. 6 will move to position after 5, and elements from 11 to 13
 * will move one position ahead of their current position.
 * 5, 6, 11, 12, 13
 * *
 * Time Complexity: O(n*n)
 * *
 * Auxiliary Space: O(1)
 * *
 * Boundary Cases:
 * Insertion sort takes maximum time to sort if elements are sorted
 * in reverse order. And it takes minimum time (Order of n) when elements
 * are already sorted.
 * *
 * Algorithmic Paradigm: Incremental Approach
 * *
 * Sorting In Place: Yes
 * *
 * Stable: Yes
 * *
 * Online: Yes
 * *
 * Uses:
 * Insertion sort is used when number of elements is small.
 * It can also be useful when input array is almost sorted,
 * only few elements are misplaced in complete big array.
 * *
 * http://www.geeksforgeeks.org/insertion-sort/
 */
public final class InsertionSort implements Sort {

    @Override
    public void sort(final int[] array) {
        for (int i = 1; i < array.length; i++) {
            final int key = array[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
