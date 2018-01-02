import com.sorting.algorithms.BubbleSort.BubbleSort;
import com.sorting.algorithms.CocktailSort.CocktailSort;
import com.sorting.algorithms.CombSort.CombSort;
import com.sorting.algorithms.GnomeSort.GnomeSort;
import com.sorting.algorithms.HeapSort.HeapSort;
import com.sorting.algorithms.InsertionSort.InsertionSort;
import com.sorting.algorithms.IterativeQuickSort.IterativeQuickSort;
import com.sorting.algorithms.MergeSort.MergeSort;
import com.sorting.algorithms.OddEvenSort.OddEvenSort;
import com.sorting.algorithms.OptimizedBubbleSort.OptimizedBubbleSort;
import com.sorting.algorithms.QuickSort.QuickSort;
import com.sorting.algorithms.RadixSort.RadixSort;
import com.sorting.algorithms.RecursiveInsertionSort.RecursiveInsertionSort;
import com.sorting.algorithms.SelectionSort.SelectionSort;
import com.sorting.algorithms.ShellSort.ShellSort;
import com.sorting.algorithms.Sort;
import com.sorting.tester.Tester;

public class Main {

    public static void main(String[] args) {
        test(new BubbleSort());
        test(new CocktailSort());
        test(new CombSort());
        test(new GnomeSort());
        test(new HeapSort());
        test(new InsertionSort());
        test(new IterativeQuickSort());
        test(new MergeSort());
        test(new OddEvenSort());
        test(new OptimizedBubbleSort());
        test(new QuickSort());
        //test(new RadixSort());
        test(new RecursiveInsertionSort());
        test(new SelectionSort());
        test(new ShellSort());
    }

    private static void test(final Sort sort) {
        new Tester(sort).run();
    }
}
