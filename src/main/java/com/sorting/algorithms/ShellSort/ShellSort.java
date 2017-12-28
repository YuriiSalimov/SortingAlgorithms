package com.sorting.algorithms.ShellSort;

import com.sorting.algorithms.Sort;

/**
 * ShellSort    O(n^2)
 * *
 * ShellSort is mainly a variation of Insertion Sort.
 * In insertion sort, we move elements only one position ahead.
 * When an element has to be moved far ahead, many movements are
 * involved. The idea of shellSort is to allow exchange of far
 * items. In shellSort, we make the array h-sorted for a large
 * value of h. We keep reducing the value of h until it becomes 1.
 * An array is said to be h-sorted if all sublists of every h’th
 * element is sorted.
 * *
 * Time Complexity:
 * Time complexity of above implementation of shellsort is O(n^2).
 * In the above implementation gap is reduce by half in every iteration.
 * There are many other ways to reduce gap which lead to better time
 * complexity. See this for more details.
 * *
 * http://www.geeksforgeeks.org/shellsort/
 */
public final class ShellSort implements Sort {

    @Override
    public void sort(final int[] array) {
        // Start with a big gap, then reduce the gap
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < array.length; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = array[i];
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                // put temp (the original a[i]) in its correct
                // location
                array[j] = temp;
            }
        }
    }
}
