package com.sorting.algorithms.InsertionSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    void sort() {
        final Sort sort = new InsertionSort();
        new Tester(sort).test();
    }
}