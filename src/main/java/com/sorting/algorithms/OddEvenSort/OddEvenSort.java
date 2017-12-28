package com.sorting.algorithms.OddEvenSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

public final class OddEvenSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = (i % 2 == 0) ? 0 : 1;
            for (; j < array.length - 1; j += 2) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
