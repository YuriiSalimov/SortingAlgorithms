package com.sorting.algorithms.MergeSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * MergeSort O(n*log(n))
 * *
 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm.
 * It divides input array in two halves, calls itself for the two
 * halves and then merges the two sorted halves. The merge() function
 * is used for merging two halves. The merge(array, l, m, r) is key process
 * that assumes that v[l..m] and array[m+1..r] are sorted and merges
 * the two sorted sub-arrays into one.
 * See following C implementation for details:
 * *
 * MergeSort(array[], l,  r)
 * If r > l
 * 1. Find the middle point to divide the array into two halves:
 * middle m = (l+r)/2
 * 2. Call mergeSort for first half:
 * Call mergeSort(array, l, m)
 * 3. Call mergeSort for second half:
 * Call mergeSort(array, m+1, r)
 * 4. Merge the two halves sorted in step 2 and 3:
 * Call merge(array, l, m, r)
 * *
 * Time Complexity: Sorting arrays on different machines.
 * Merge Sort is a recursive algorithm and time complexity can be expressed
 * as following recurrence relation.
 * T(n) = 2T(n/2) + Theta(n)
 * The above recurrence can be solved either using Recurrence Tree method
 * or Master method. It falls in case II of Master Method and solution of
 * the recurrence is Theta(n*Log(n)). Time complexity of Merge Sort is
 * Theta(n*Log(n)) in all 3 cases (worst, average and best) as merge sort
 * always divides the array in two halves and take linear time to merge two halves.
 * *
 * Auxiliary Space: O(n)
 * *
 * Algorithmic Paradigm: Divide and Conquer
 * *
 * Sorting In Place: No in a typical implementation
 * *
 * Stable: Yes
 * *
 * Applications of Merge Sort
 * 1. Merge Sort is useful for sorting linked lists in O(nLogn) time.
 * In case of linked lists the case is different mainly due to difference
 * in memory allocation of arrays and linked lists. Unlike arrays,
 * linked list nodes may not be adjacent in memory. Unlike array,
 * in linked list, we can insert items in the middle in O(1) extra space
 * and O(1) time. Therefore merge operation of merge sort can be implemented
 * without extra space for linked lists.
 * In arrays, we can do random access as elements are continuous in memory.
 * Let us say we have an integer (4-byte) array A and let the address of A[0]
 * be x then to access A[i], we can directly access the memory at (x + i*4).
 * Unlike arrays, we can not do random access in linked list. Quick Sort requires
 * a lot of this kind of access. In linked list to access i’th index, we have
 * to travel each and every node from the head to i’th node as we don’t have
 * continuous block of memory. Therefore, the overhead increases for quick sort.
 * Merge sort accesses data sequentially and the need of random access is low.
 * 2. Inversion Count Problem
 * 3. Used in External Sorting
 * *
 * http://www.geeksforgeeks.org/merge-sort/
 */
public final class MergeSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    // Main function that sorts array[l..r] using
    // merge()
    private void mergeSort(
            final int array[],
            final int l,
            final int r
    ) {
        if (l < r) {
            // Find the middle point
            final int m = (l + r) / 2;
            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is array[l..m]
    // Second subarray is array[m+1..r]
    private void merge(
            final int[] array,
            final int l,
            final int m,
            final int r
    ) {
        /* Create temp subarrays */
        final int first[] = new int[m - l + 1];
        final int second[] = new int[r - m];
        /*Copy data to temp arrays*/
        System.arraycopy(array, l, first, 0, first.length);
        System.arraycopy(array, m + 1, second, 0, second.length);
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;
        while (i < first.length && j < second.length) {
            array[k++] = (first[i] <= second[j]) ? first[i++] : second[j++];
        }
        /* Copy remaining elements of first[] if any */
        while (i < first.length) {
            array[k++] = first[i++];
        }
        /* Copy remaining elements of second[] if any */
        while (j < second.length) {
            array[k++] = second[j++];
        }
    }
}
