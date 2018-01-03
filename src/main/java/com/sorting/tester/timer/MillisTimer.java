package com.sorting.tester.timer;

public final class MillisTimer extends AbstractTimer {

    @Override
    protected double currentTime() {
        return System.currentTimeMillis();
    }
}
