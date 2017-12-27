package com.sorting.algorithms.CombSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

public final class CombSort
        extends AbstractSort implements Sort {

    private final static double REDUCTION_FACTOR = 1.247330950103979;

    @Override
    public void sort(final int[] array) {
        int gap = array.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / REDUCTION_FACTOR);
            }
            int i = 0;
            swapped = false;
            while (i + gap < array.length) {
                if (array[i] > array[i + gap]) {
                    swap(array, i, i + gap);
                    swapped = true;
                }
                i++;
            }
        }
    }
}
