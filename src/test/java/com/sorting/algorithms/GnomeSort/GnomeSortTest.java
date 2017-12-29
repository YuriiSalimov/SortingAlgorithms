package com.sorting.algorithms.GnomeSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GnomeSortTest {

    @Test
    void sort() {
        final Sort sort = new GnomeSort();
        new Tester(sort).test();
    }
}