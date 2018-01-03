package com.sorting.demonstration.arrays;

import java.util.Random;

public final class SingleArraysFactory implements ArraysFactory {

    private static final Random RANDOM = new Random();

    @Override
    public int[] create(final int length) {
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = RANDOM.nextInt();
        }
        return array;
    }
}
