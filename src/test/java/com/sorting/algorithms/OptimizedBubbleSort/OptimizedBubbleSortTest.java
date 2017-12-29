package com.sorting.algorithms.OptimizedBubbleSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimizedBubbleSortTest {

    @Test
    void sort() {
        final Sort sort = new OptimizedBubbleSort();
        new Tester(sort).test();
    }
}