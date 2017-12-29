package com.sorting.algorithms.BubbleSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void sort() {
        final Sort sort = new BubbleSort();
        new Tester(sort).test();
    }
}
