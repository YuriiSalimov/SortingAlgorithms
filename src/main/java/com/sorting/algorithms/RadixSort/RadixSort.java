package com.sorting.algorithms.RadixSort;

import com.sorting.algorithms.Sort;

/**
 * RadixSort
 * *
 * The lower bound for Comparison based sorting algorithm
 * (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(nLogn), i.e.,
 * they cannot do better than nLogn.
 * *
 * Counting sort is a linear time sorting algorithm that sort in O(n+k)
 * time when elements are in range from 1 to k.
 * *
 * What if the elements are in range from 1 to n2?
 * We can’t use counting sort because counting sort will take O(n2)
 * which is worse than comparison based sorting algorithms.
 * Can we sort such an array in linear time?
 * Radix Sort is the answer. The idea of Radix Sort is to do digit by
 * digit sort starting from least significant digit to most significant
 * digit. Radix sort uses counting sort as a subroutine to sort.
 * *
 * The Radix Sort Algorithm
 * 1) Do following for each digit i where i varies from least significant
 * digit to the most significant digit.
 * ………….a) Sort input array using counting sort (or any stable sort)
 * ………….according to the i’th digit.
 * *
 * Example:
 * Original, unsorted list:
 * 170, 45, 75, 90, 802, 24, 2, 66
 * Sorting by least significant digit (1s place) gives:
 * [*Notice that we keep 802 before 2, because 802 occurred before 2
 * in the original list, and similarly for pairs 170 & 90 and 45 & 75.]
 * *
 * 170, 90, 802, 2, 24, 45, 75, 66
 * Sorting by next digit (10s place) gives:
 * [*Notice that 802 again comes before 2 as 802 comes before 2
 * in the previous list.]
 * *
 * 802, 2, 24, 45, 66, 170, 75, 90
 * Sorting by most significant digit (100s place) gives:
 * *
 * 2, 24, 45, 66, 75, 90, 170, 802
 * What is the running time of Radix Sort?
 * Let there be d digits in input integers. Radix Sort takes O(d*(n+b))
 * time where b is the base for representing numbers, for example,
 * for decimal system, b is 10. What is the value of d? If k is the maximum
 * possible value, then d would be O(logb(k)). So overall time complexity
 * is O((n+b) * logb(k)). Which looks more than the time complexity of comparison
 * based sorting algorithms for a large k. Let us first limit k. Let k <= nc where c
 * is a constant. In that case, the complexity becomes O(nLogb(n)). But it still
 * doesn’t beat comparison based sorting algorithms.
 * What if we make value of b larger?. What should be the value of b to make the
 * time complexity linear? If we set b as n, we get the time complexity as O(n).
 * In other words, we can sort an array of integers with range from 1 to nc if the
 * numbers are represented in base n (or every digit takes log2(n) bits).
 * *
 * Is Radix Sort preferable to Comparison based sorting algorithms like Quick-Sort?
 * If we have log2n bits for every digit, the running time of Radix appears to be
 * better than Quick Sort for a wide range of input numbers. The constant factors
 * hidden in asymptotic notation are higher for Radix Sort and Quick-Sort uses hardware
 * caches more effectively. Also, Radix sort uses counting sort as a subroutine and
 * counting sort takes extra space to sort numbers.
 * *
 * Recommended: Please try your approach on {IDE} first, before moving on to the solution.
 * *
 * Implementation of Radix Sort
 * Following is a simple C++ implementation of Radix Sort. For simplicity, the value of d
 * is assumed to be 10. We recommend you to see Counting Sort for details of countSort()
 * function in below code.
 * *
 * http://www.geeksforgeeks.org/radix-sort/
 */
public final class RadixSort implements Sort {

    @Override
    public void sort(final int[] array) {
        radixSort(array, array.length);
    }

    // The main function to that sorts arr[] of size using
    // Radix Sort
    private void radixSort(final int[] array, final int size) {
        // Find the maximum number to know number of digits
        final int max = getMax(array, size);
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, size, exp);
        }
    }

    // A utility function to get maximum value in arr[]
    private int getMax(final int[] array, final int size) {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private void countSort(
            final int[] array,
            final int size,
            final int exp
    ) {
        final int output[] = new int[size]; // output array
        final int count[] = new int[10];
        // Store count of occurrences in count[]
        for (int i = 0; i < size; i++) {
            count[(array[i] / exp) % 10]++;
        }
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        System.arraycopy(output, 0, array, 0, size);
    }
}
