package com.sorting.tester.timer;

public final class NanoTimer extends AbstractTimer {

    @Override
    protected double currentTime() {
        return System.nanoTime();
    }
}
