package com.sorting.algorithms.RecursiveInsertionSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveInsertionSortTest {

    @Test
    void sort() {
        final Sort sort = new RecursiveInsertionSort();
        new Tester(sort).test();
    }
}