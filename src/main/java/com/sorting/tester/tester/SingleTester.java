package com.sorting.tester.tester;

import com.sorting.tester.Config;
import com.sorting.tester.Loader;
import com.sorting.tester.SortTimer;

import java.io.IOException;
import java.util.Random;

public final class SingleTester implements Tester {

    private static final Random RANDOM = new Random();

    private final String name;
    private final SortTimer timer;
    private final Config config;

    private long prevTime;
    private long prevPrevTime;

    public SingleTester(final String name, final SortTimer timer, final Config config) {
        this.name = name;
        this.timer = timer;
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
            final long time = calcTime(i);
            if (isValidTime(time)) {
                i -= this.config.getArrayLengthStep();
            } else {
                saveTime(time);
                sb.append(i).append(" ").append(time).append("\n");
            }
        }
        return sb.toString();
    }

    private void saveTable(final String table) throws IOException {
        final String path = getPath();
        final Loader loader = new Loader(path, table);
        loader.write();
    }

    private long calcTime(final int arrayLength) {
        long time = 0;
        for (int i = 0; i < this.config.getIterations(); i++) {
            final int[] array = createArray(arrayLength);
            time += this.timer.calcTime(array);
        }
        return (time / this.config.getIterations());
    }

    private int[] createArray(final int length) {
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = RANDOM.nextInt();
        }
        return array;
    }

    private boolean isValidTime(final long time) {
        return (this.prevPrevTime != 0) &&
                (time - this.prevPrevTime) > ((double) this.prevPrevTime * this.config.getTimeRange());
    }

    private void saveTime(final long time) {
        this.prevPrevTime = this.prevTime;
        this.prevTime = time;
    }

    private String getPath() {
        return this.config.getResultPathPrefix() + this.name + this.config.getResultPathSuffix();
    }
}
