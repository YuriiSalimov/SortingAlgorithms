package com.sorting.algorithms.HeapSort;

import com.sorting.algorithms.AbstractSort;
import com.sorting.algorithms.Sort;

/**
 * HeapSort
 * *
 * Heap sort is a comparison based sorting technique based
 * on Binary Heap data structure. It is similar to selection
 * sort where we first find the maximum element and place
 * the maximum element at the end. We repeat the same process
 * for remaining element.
 * *
 * What is Binary Heap?
 * Let us first define a Complete Binary Tree. A complete binary
 * tree is a binary tree in which every level, except possibly
 * the last, is completely filled, and all nodes are as far left
 * as possible (Source Wikipedia)
 * *
 * A Binary Heap is a Complete Binary Tree where items are stored
 * in a special order such that value in a parent node is greater
 * (or smaller) than the values in its two children nodes. The former i
 * s called as max heap and the latter is called min heap.
 * The heap can be represented by binary tree or array.
 * *
 * Why array based representation for Binary Heap?
 * Since a Binary Heap is a Complete Binary Tree, it can be easily represented
 * as array and array based representation is space efficient. If the parent
 * node is stored at index I, the left child can be calculated by 2 * I + 1
 * and right child by 2 * I + 2 (assuming the indexing starts at 0).
 * *
 * Heap Sort Algorithm for sorting in increasing order:
 * 1. Build a max heap from the input data.
 * 2. At this point, the largest item is stored at the root of the heap.
 * Replace it with the last item of the heap followed by reducing the size
 * of heap by 1. Finally, heapify the root of tree.
 * 3. Repeat above steps while size of heap is greater than 1.
 * *
 * How to build the heap?
 * Heapify procedure can be applied to a node only if its children nodes
 * are heapified. So the heapification must be performed in the bottom up order.
 * *
 * Notes:
 * Heap sort is an in-place algorithm.
 * Its typical implementation is not stable, but can be made stable (See this)
 * *
 * Time Complexity:
 * Time complexity of heapify is O(Log(n)). Time complexity of createAndBuildHeap()
 * is O(n) and overall time complexity of Heap Sort is O(nLogn).
 * *
 * Applications of HeapSort
 * 1. Sort a nearly sorted (or K sorted) array.
 * 2. k largest(or smallest) elements in an array.
 * *
 * http://www.geeksforgeeks.org/heap-sort/
 */
public final class HeapSort
        extends AbstractSort implements Sort {

    @Override
    public void sort(final int[] array) {
        // Build heap (rearrange array)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // One by one extract an element from heap
        for (int i = array.length - 1; i >= 0; i--) {
            // Move current root to end
            swap(array, 0, i);
            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(
            final int[] array,
            final int n,
            final int i
    ) {
        int largest = i;  // Initialize largest as root
        final int left = 2 * i + 1;
        final int right = 2 * i + 2;
        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        // If largest is not root
        if (largest != i) {
            swap(array, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
}
