package com.sorting.algorithms.BogoSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * BogoSort O(n * n!)
 */
public final class BogoSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        while (!correct(array)) {
            shuffle(array);
        }
    }

    private boolean correct(final int[] array) {
        boolean correct = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                correct = false;
                break;
            }
        }
        return correct;
    }

    private void shuffle(final int[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            swap(array, i, random.nextInt(array.length));
        }
    }
}
