package com.sorting.algorithms.BogoSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BogoSortTest {

    private static final int ARRAY_LENGTH = 10;
    private static final int ITERATIONS = 2;

    @Test
    void sort() {
        final Sort sort = new BogoSort();
        new Tester(sort, ARRAY_LENGTH, ITERATIONS).test();
    }
}