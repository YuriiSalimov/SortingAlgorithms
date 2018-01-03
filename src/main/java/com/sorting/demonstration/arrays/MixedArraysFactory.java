package com.sorting.demonstration.arrays;

public final class MixedArraysFactory implements ArraysFactory {

    private final ArraysFactory arraysFactory;

    public MixedArraysFactory(final ArraysFactory arraysFactory) {
        this.arraysFactory = arraysFactory;
    }

    @Override
    public int[] create(int length) {
        int[] array;
        do {
            array = this.arraysFactory.create(length);
        } while (!isMixed(array));
        return array;
    }

    private boolean isMixed(final int[] array) {
        boolean result = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                result = true;
                break;
            }
        }
        return result;
    }
}
