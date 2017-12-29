package com.sorting.algorithms.SelectionSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

    @Test
    void sort() {
        final Sort sort = new SelectionSort();
        new Tester(sort).test();
    }
}