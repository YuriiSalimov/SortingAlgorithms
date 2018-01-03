package com.sorting.demonstration.tester;

import com.sorting.demonstration.Config;
import com.sorting.demonstration.Loader;
import com.sorting.demonstration.SortTimer;
import com.sorting.demonstration.arrays.ArraysFactory;
import com.sorting.demonstration.timer.MillisTimer;
import com.sorting.demonstration.timer.Timer;

import java.io.IOException;
import java.util.Random;

public final class SingleTester implements Tester {

    private final String name;
    private final SortTimer timer;
    private final ArraysFactory arraysFactory;
    private final Config config;
    private final TimeCache timeCache = new TimeCache();

    public SingleTester(
            final String name,
            final SortTimer timer,
            final ArraysFactory arraysFactory,
            final Config config
    ) {
        this.name = name;
        this.timer = timer;
        this.arraysFactory = arraysFactory;
        this.config = config;
    }

    @Override
    public void test() {
        try {
            System.out.println(this.name + " - start");
            final String table = createTable();
            saveTable(table);
            System.out.println(this.name + " - DONE");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String createTable() {
        final StringBuilder sb = new StringBuilder();
        for (int i = this.config.getMinArrayLength(); i <= this.config.getMaxArrayLength(); i += this.config.getArrayLengthStep()) {
            final double time = calcTime(i);
            sb.append(i).append(" ").append(time).append("\n");
            System.out.println(this.name + " - " + i + " - " + time);
        }
        return sb.toString();
    }

    private void saveTable(final String table) throws IOException {
        final String path = getPath();
        final Loader loader = new Loader(path, table);
        loader.write();
    }

    private double calcTime(final int arrayLength) {
        double sumTime = 0;
        this.timeCache.clearTime();
        for (int i = 0; i < this.config.getIterations(); i++) {
            final int[] array = this.arraysFactory.create(arrayLength);
            final double time = this.timer.calcTime(array);
            if (this.timeCache.isValidTime(time)) {
                sumTime += time / this.config.getIterations();
                this.timeCache.saveTime(time);
            } else {
                i--;
            }
        }
        return sumTime;
    }

    private String getPath() {
        return this.config.getResultPathPrefix() + this.name + this.config.getResultPathSuffix();
    }

    private final class TimeCache {

        private double prevTime;
        private double prevPrevTime;

        private boolean isValidTime(final double time) {
            return (this.prevPrevTime == 0) || (time <= this.prevPrevTime * (1 + config.getTimeRange()));
        }

        private void saveTime(final double time) {
            this.prevPrevTime = this.prevTime;
            this.prevTime = time;
        }

        private void clearTime() {
            this.prevPrevTime = 0;
            this.prevTime = 0;
        }
    }
}
