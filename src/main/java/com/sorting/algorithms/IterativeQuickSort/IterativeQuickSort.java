package com.sorting.algorithms.IterativeQuickSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * IterativeQuickSort
 * *
 * Following is a typical recursive implementation
 * of Quick Sort that uses last element as pivot.
 * *
 * The above implementation can be optimized in many ways:
 * 1) The implementation with last index as pivot - is causes
 * worst-case behavior on already sorted arrays, which is a
 * commonly occurring case. The problem can be solved by choosing
 * either a random index for the pivot, or choosing the middle
 * index of the partition or choosing the median of the first,
 * middle and last element of the partition for the pivot. (See this for details)
 * 2) To reduce the recursion depth, recur first for the smaller
 * half of the array, and use a tail call to recurse into the other.
 * 3) Insertion sort works better for small subarrays.
 * Insertion sort can be used for invocations on such small arrays
 * (i.e. where the length is less than a threshold t determined
 * experimentally). For example, this library implementation of
 * qsort uses insertion sort below size 7.
 * *
 * Despite above optimizations, the function remains recursive and
 * uses function call stack to store intermediate values of l and h.
 * The function call stack stores other bookkeeping information together
 * with parameters. Also, function calls involve overheads like storing
 * activation record of the caller function and then resuming execution.
 * *
 * The above function can be easily converted to iterative version with
 * the help of an auxiliary stack. Following is an iterative implementation
 * of the above recursive code.
 * *
 * The above mentioned optimizations for recursive quick sort can also be
 * applied to iterative version.
 * 1) Partition process is same in both recursive and iterative.
 * The same techniques to choose optimal pivot can also be applied to iterative version.
 * 2) To reduce the stack size, first push the indexes of smaller half.
 * 3) Use insertion sort when the size reduces below a experimentally calculated threshold.
 * *
 * http://www.geeksforgeeks.org/iterative-quick-sort/
 */
public final class IterativeQuickSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Sorts arr[l..h] using iterative QuickSort
     */
    private void quickSort(
            final int[] array,
            int low,
            int high
    ) {
        // create auxiliary stack
        final int stack[] = new int[high - low + 1];
        // initialize top of stack
        int top = -1;
        // push initial values in the stack
        stack[++top] = low;
        stack[++top] = high;
        // keep popping elements until stack is not empty
        while (top >= 0) {
            // pop h and l
            high = stack[top--];
            low = stack[top--];
            // set pivot element at it's proper position
            final int pivot = partition(array, low, high);
            // If there are elements on left side of pivot,
            // then push left side to stack
            if (pivot - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivot - 1;
            }
            // If there are elements on right side of pivot,
            // then push right side to stack
            if (pivot + 1 < high) {
                stack[++top] = pivot + 1;
                stack[++top] = high;
            }
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(
            final int array[],
            final int low,
            final int high
    ) {
        int x = array[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= x) {
                i++;
                // swap arr[i] and arr[j]
                swap(array, i, j);
            }
        }
        // swap arr[i+1] and arr[h]
        swap(array, i + 1, high);
        return (i + 1);
    }
}
