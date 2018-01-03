package com.sorting.demonstration.timer;

public final class SecondTimer extends AbstractTimer {

    private final AbstractTimer timer = new MillisTimer();

    @Override
    protected double currentTime() {
        final double millis = this.timer.currentTime();
        return toSeconds(millis);
    }

    private double toSeconds(final double millis) {
        return (millis / 1000);
    }
}
