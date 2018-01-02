package com.sorting.tester;

import com.sorting.algorithms.Sort;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public final class Tester {

    private static final int MIN_ARRAY_LENGTH = 10;
    private static final int MAX_ARRAY_LENGTH = 1000;
    private static final int STEP = 1;
    private static final int ITERATIONS = 100;
    private static final String PATH_PREFIX = "results/";
    private static final String PATH_SUFFIX = ".sort";
    private static final double TIME_RANGE = 0.3;
    private static final Random RANDOM = new Random();

    private final Sort sort;
    private long prevTime;

    public Tester(final Sort sort) {
        this.sort = sort;
    }

    public void run() {
        System.out.println(getName() + " - start");
        try {
            final String table = createTable();
            saveTable(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(getName() + " - DONE");
    }

    private String createTable() {
        final StringBuilder sb = new StringBuilder();
        for (int i = MIN_ARRAY_LENGTH; i <= MAX_ARRAY_LENGTH; i += STEP) {
            final long time = calcTime(i);
            if (isValidTime(time)) {
                i -= STEP;
            } else {
                this.prevTime = time;
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
        for (int i = 0; i < ITERATIONS; i++) {
            final int[] array = createArray(arrayLength);
            final SortTimer timer = new SortTimer(this.sort, array);
            time += timer.sort();
        }
        return (time / ITERATIONS);
    }

    private int[] createArray(final int length) {
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = RANDOM.nextInt();
        }
        return array;
    }

    private boolean isValidTime(final long time) {
        return (this.prevTime != 0) && (time - this.prevTime) > ((double) this.prevTime * TIME_RANGE);
    }

    private String getPath() {
        return PATH_PREFIX + getName() + PATH_SUFFIX;
    }

    private String getName() {
        return this.sort.getClass().getSimpleName();
    }
}
