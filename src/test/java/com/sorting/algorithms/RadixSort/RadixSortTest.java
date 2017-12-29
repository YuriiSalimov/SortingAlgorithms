package com.sorting.algorithms.RadixSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    void sort() {
        final Sort sort = new RadixSort();
        new Tester(sort).test();
    }
}