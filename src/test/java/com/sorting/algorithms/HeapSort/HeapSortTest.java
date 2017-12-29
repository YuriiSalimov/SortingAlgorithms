package com.sorting.algorithms.HeapSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void sort() {
        final Sort sort = new HeapSort();
        new Tester(sort).test();
    }
}