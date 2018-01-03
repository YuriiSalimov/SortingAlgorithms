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
        double time = 0;
        for (int i = 0; i < this.config.getIterations(); i++) {
            final int[] array = this.arraysFactory.create(arrayLength);
            time += (this.timer.calcTime(array) / this.config.getIterations());
        }
        return time;
    }

    private String getPath() {
        return this.config.getResultPathPrefix() + this.name + this.config.getResultPathSuffix();
    }
}
