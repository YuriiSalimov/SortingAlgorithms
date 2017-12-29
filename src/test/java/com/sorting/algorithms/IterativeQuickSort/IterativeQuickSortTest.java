package com.sorting.algorithms.IterativeQuickSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IterativeQuickSortTest {

    @Test
    void sort() {
        final Sort sort = new IterativeQuickSort();
        new Tester(sort).test();
    }
}