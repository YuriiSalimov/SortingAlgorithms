package com.sorting.algorithms;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public final class Tester {

    private static final int ARRAY_LENGTH = 10000;
    private static final double LENGTH_PART = 0.1;
    private static final int ITERATIONS = 100;
    private static final Random RANDOM = new Random();

    private final Sort sort;
    private int arrayLength;
    private final int iterations;

    public Tester(final Sort sort, final int arrayLength, final int iterations) {
        this.sort = sort;
        this.arrayLength = arrayLength;
        this.iterations = iterations;
    }

    public Tester(final Sort sort, final int arrayLength) {
        this(sort, arrayLength, ITERATIONS);
    }

    public Tester(final Sort sort) {
        this(sort, ARRAY_LENGTH, ITERATIONS);
    }

    public void test() {
        int count = 0;
        boolean done = false;
        do {
            try {
                this.arrayLength = (int) (this.arrayLength * (1 - LENGTH_PART * count));
                go();
                done = true;
            } catch (StackOverflowError er) {
                count++;
            }
        } while (!done);
    }

    private void go() {
        long time = 0;
        for (int i = 0; i < this.iterations; i++) {
            final int[] array = createRandomArray();
            time += sort(array);
            assertArray(array);
        }
        time /= this.iterations;
        printResult(time);
    }

    private void assertArray(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    private void printResult(final long time) {
        System.out.print(this.sort.getClass().getSimpleName());
        System.out.print("(" + this.arrayLength + ")");
        System.out.print(" - ");
        final long ms = time / 1000000;
        final long ns = time - ms * 1000000;
        System.out.println(ms + " ms " + ns + " ns");
    }

    private int[] createRandomArray() {
        final int[] array = new int[this.arrayLength];
        for (int i = 0; i < this.arrayLength; i++) {
            array[i] = RANDOM.nextInt(this.arrayLength);
        }
        return array;
    }

    private long sort(final int[] array) {
        final long start = time();
        this.sort.sort(array);
        final long end = time();
        return (end - start);
    }

    private long time() {
        return System.nanoTime();
    }
}
