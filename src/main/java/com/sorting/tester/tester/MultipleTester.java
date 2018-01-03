package com.sorting.tester.tester;

import java.util.concurrent.Executor;

public final class MultipleTester implements Tester, Runnable {

    private final Tester tester;
    private final Executor executor;

    public MultipleTester(final Tester tester, final Executor executor) {
        this.tester = tester;
        this.executor = executor;
    }

    @Override
    public void test() {
        this.executor.execute(this);
    }

    @Override
    public void run() {
        this.tester.test();
    }
}
