package com.sorting.tester.timer;

public final class SecondTimer extends AbstractTimer {

    @Override
    protected double currentTime() {
        final long millis = System.currentTimeMillis();
        return toSeconds(millis);
    }

    private double toSeconds(final long millis) {
        return (((double) millis) / 1000);
    }
}
