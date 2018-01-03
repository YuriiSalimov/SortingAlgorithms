package com.sorting.tester;

import com.sorting.algorithms.Sort;
import com.sorting.tester.timer.Timer;

public final class SortTimer {

    private final Sort sort;
    private final Timer timer;

    public SortTimer(final Sort sort, final Timer timer) {
        this.sort = sort;
        this.timer = timer;
    }

    public double calcTime(final int[] array) {
        this.timer.start();
        this.sort.sort(array);
        this.timer.stop();
        return this.timer.time();
    }
}
