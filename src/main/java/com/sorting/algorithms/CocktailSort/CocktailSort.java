package com.sorting.algorithms.CocktailSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

public final class CocktailSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            left++;
        } while (left < right);
    }
}
