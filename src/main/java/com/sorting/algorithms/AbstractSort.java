package com.sorting.algorithms;

public abstract class AbstractSort implements Sort {

    /**
     * swap array[first] and arr[second]
     */
    protected void swap(
            final int[] array,
            final int first,
            final int second
    ) {
        final int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
