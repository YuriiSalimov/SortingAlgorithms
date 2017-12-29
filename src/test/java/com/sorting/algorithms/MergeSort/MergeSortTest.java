package com.sorting.algorithms.MergeSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        final Sort sort = new MergeSort();
        new Tester(sort).test();
    }
}