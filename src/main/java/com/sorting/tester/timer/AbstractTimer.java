package com.sorting.tester.timer;

abstract class AbstractTimer implements Timer {

    private double start;
    private double stop;

    @Override
    public void start() {
        this.start = currentTime();
    }

    @Override
    public void stop() {
        this.stop = currentTime();
    }

    @Override
    public double time() {
        final double time;
        if (this.start > this.stop) {
            time = -1;
        } else {
            time = this.stop - this.start;
        }
        return time;
    }

    @Override
    public void clear() {
        this.start = 0;
        this.stop = 0;
    }

    protected abstract double currentTime();
}
