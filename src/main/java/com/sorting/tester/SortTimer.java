package com.sorting.tester;

import com.sorting.algorithms.Sort;

public final class SortTimer {

    private static final boolean NANO = true;

    private final Sort sort;

    private final int[] array;

    public SortTimer(final Sort sort, final int[] array) {
        this.sort = sort;
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public long sort() {
        final long start = time();
        this.sort.sort(this.array);
        final long end = time();
        return (end - start);
    }

    private long time() {
        return NANO ? System.nanoTime() : System.currentTimeMillis();
    }
}
