package com.sorting.algorithms.ShellSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @Test
    void sort() {
        final Sort sort = new ShellSort();
        new Tester(sort).test();
    }
}