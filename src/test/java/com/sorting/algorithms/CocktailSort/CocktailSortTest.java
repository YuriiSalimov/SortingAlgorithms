package com.sorting.algorithms.CocktailSort;

import com.sorting.algorithms.Sort;
import com.sorting.algorithms.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CocktailSortTest {

    @Test
    void sort() {
        final Sort sort = new CocktailSort();
        new Tester(sort).test();
    }
}