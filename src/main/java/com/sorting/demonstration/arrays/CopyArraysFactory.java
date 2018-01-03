package com.sorting.demonstration.arrays;

import java.util.Arrays;

public final class CopyArraysFactory implements ArraysFactory {

    private final ArraysFactory arraysFactory;

    public CopyArraysFactory(final ArraysFactory arraysFactory) {
        this.arraysFactory = arraysFactory;
    }

    @Override
    public int[] create(final int length) {
        final int[] array = this.arraysFactory.create(length);
        return Arrays.copyOf(array, length);
    }
}
