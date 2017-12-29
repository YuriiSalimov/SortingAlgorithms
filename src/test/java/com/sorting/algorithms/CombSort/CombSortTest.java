package com.sorting.algorithms.CombSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombSortTest {

    @Test
    void sort() {
        final Sort sort = new CombSort();
        new Tester(sort).test();
    }
}