package com.sorting.algorithms.GnomeSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

public final class GnomeSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        int i = 1;
        while (i < array.length) {
            if (i == 0 || array[i - 1] <= array[i])
                i++;
            else {
                swap(array, i, i - 1);
                i--;
            }
        }
    }
}
