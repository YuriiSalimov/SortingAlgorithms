package com.sorting.algorithms.QuickSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        final Sort sort = new QuickSort();
        new Tester(sort).test();
    }
}