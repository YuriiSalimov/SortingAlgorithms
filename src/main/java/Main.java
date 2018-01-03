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
import com.sorting.tester.Config;
import com.sorting.tester.SortTimer;
import com.sorting.tester.tester.MultipleTester;
import com.sorting.tester.tester.SingleTester;
import com.sorting.tester.tester.Tester;
import com.sorting.tester.timer.MillisTimer;
import com.sorting.tester.timer.NanoTimer;
import com.sorting.tester.timer.SecondTimer;
import com.sorting.tester.timer.Timer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private enum TimeUnits {
        NANOS, MILLIS, SECONDS
    }

    private static final TimeUnits TIME_UNIT = TimeUnits.SECONDS;
    private static final int MIN_ARRAY_LENGTH = 10;
    private static final int MAX_ARRAY_LENGTH = 1000;
    private static final int STEP = 1;
    private static final int ITERATIONS = 100;
    private static final String PATH_PREFIX = "results/";
    private static final String PATH_SUFFIX = ".sort";
    private static final double TIME_RANGE = 0.3;
    private static final boolean MULTIPLE = true;
    private static final int THREADS_NUMBER = 2;

    private static Config config;
    private static Timer timer;
    private static ExecutorService executor;

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
        test(new RecursiveInsertionSort());
        test(new SelectionSort());
        test(new ShellSort());
        //test(new RadixSort());
        executorShutdown();
    }

    private static void test(final Sort sort) {
        final Tester tester = createTester(sort);
        tester.test();
    }

    private static Tester createTester(final Sort sort) {
        final String name = getSortName(sort);
        final SortTimer timer = createSortTimer(sort);
        final Config config = getConfig();
        final Tester tester = new SingleTester(name, timer, config);
        return checkMultiple(tester);
    }

    private static Tester checkMultiple(final Tester tester) {
        final Tester resultTester;
        if (MULTIPLE) {
            final Executor executor = getExecutor();
            resultTester = new MultipleTester(tester, executor);
        } else {
            resultTester = tester;
        }
        return resultTester;
    }

    private static ExecutorService getExecutor() {
        if (executor == null) {
            executor = createExecutor();
        }
        return executor;
    }

    private static ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(THREADS_NUMBER);
    }

    private static void executorShutdown() {
        if (executor != null) {
            executor.shutdown();
            executor = null;
        }
    }

    private static SortTimer createSortTimer(final Sort sort) {
        final Timer timer = getTimer();
        return new SortTimer(sort, timer);
    }

    private static Timer getTimer() {
        if (timer == null) {
            timer = createTimer();
        }
        return timer;
    }

    private static Timer createTimer() {
        final Timer timer;
        if (TIME_UNIT == TimeUnits.NANOS) {
            timer = new NanoTimer();
        } else if (TIME_UNIT == TimeUnits.SECONDS) {
            timer = new SecondTimer();
        } else {
            timer = new MillisTimer();
        }
        return timer;
    }

    private static Config getConfig() {
        if (config == null) {
            config = createConfig();
        }
        return config;
    }

    private static Config createConfig() {
        return new Config(
                MIN_ARRAY_LENGTH,
                MAX_ARRAY_LENGTH,
                STEP,
                ITERATIONS,
                TIME_RANGE,
                PATH_PREFIX,
                PATH_SUFFIX
        );
    }

    private static String getSortName(final Sort sort) {
        return sort.getClass().getSimpleName();
    }
}
