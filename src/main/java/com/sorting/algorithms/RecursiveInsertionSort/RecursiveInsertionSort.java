package com.sorting.algorithms.RecursiveInsertionSort;

import com.sorting.algorithms.Sort;

/**
 * Recursive Insertion Sort
 * <p>
 * Insertion sort is a simple sorting algorithm that works the way
 * we sort playing cards in our hands.
 * Below is an iterative algorithm for insertion sort
 * Algorithm
 * Sort an arr[] of size n
 * insertionSort(arr, n)
 * Loop from i = 1 to n-1.
 * a) Pick element arr[i] and insert it into sorted sequence arr[0..i-1]
 * <p>
 * Recursive Insertion Sort has no performance/implementation advantages,
 * but can be a good question to check one’s understanding of Insertion Sort
 * and recursion. If we take a closer look at Insertion Sort algorithm,
 * we keep processed elements sorted and insert new elements one by one
 * in the inserted array.
 * <p>
 * Recursion Idea.
 * 1. Base Case: If array size is 1 or smaller, return.
 * 2. Recursively sort first n-1 elements.
 * 3. Insert last element at its correct position in sorted array.
 * <p>
 * http://www.geeksforgeeks.org/recursive-insertion-sort/
 */
public final class RecursiveInsertionSort
        implements Sort {

    @Override
    public void sort(final int[] array) {
        sortRecursive(array, array.length);
    }

    // Recursive function to sort an array using
    // insertion sort
    private void sortRecursive(
            final int[] array,
            final int n
    ) {
        // Base case
        if (n <= 1) {
            return;
        }
        // Sort first n-1 elements
        sortRecursive(array, n - 1);
        // Insert last element at its correct position
        // in sorted array.
        final int last = array[n - 1];
        int j = n - 2;
        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && array[j] > last) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = last;
    }
}
