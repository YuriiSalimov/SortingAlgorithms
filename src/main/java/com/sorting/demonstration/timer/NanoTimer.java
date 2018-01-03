package com.sorting.demonstration.timer;

public final class NanoTimer extends AbstractTimer {

    @Override
    protected double currentTime() {
        return System.nanoTime();
    }
}
