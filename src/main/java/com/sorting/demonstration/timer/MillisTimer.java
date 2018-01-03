package com.sorting.demonstration.timer;

public final class MillisTimer extends AbstractTimer {

    private final AbstractTimer timer = new NanoTimer();

    @Override
    protected double currentTime() {
        final double nanos = this.timer.currentTime();
        return toMillis(nanos);
    }

    private double toMillis(final double nanos) {
        return (nanos / 1000000);
    }
}
