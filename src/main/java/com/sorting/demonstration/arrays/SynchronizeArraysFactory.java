package com.sorting.demonstration.arrays;

public final class SynchronizeArraysFactory implements ArraysFactory {

    private final ArraysFactory arraysFactory;

    public SynchronizeArraysFactory(final ArraysFactory arraysFactory) {
        this.arraysFactory = arraysFactory;
    }

    @Override
    public int[] create(final int length) {
        return synchronizeCreate(length);
    }

    private synchronized int[] synchronizeCreate(final int length) {
        return this.arraysFactory.create(length);
    }
}
