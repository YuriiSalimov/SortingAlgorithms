package com.sorting.algorithms.OddEvenSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenSortTest {

    @Test
    void sort() {
        final Sort sort = new OddEvenSort();
        new Tester(sort).test();
    }
}