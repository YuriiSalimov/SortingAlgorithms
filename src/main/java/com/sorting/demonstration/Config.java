package com.sorting.demonstration;

public final class Config {

    private final int minArrayLength;
    private final int maxArrayLength;
    private final int arrayLengthStep;
    private final int iterations;
    private final String resultPathPrefix;
    private final String resultPathSuffix;

    public Config(
            final int minArrayLength,
            final int maxArrayLength,
            final int arrayLengthStep,
            final int iterations,
            final String resultPathPrefix,
            final String resultPathSuffix
    ) {
        this.minArrayLength = minArrayLength;
        this.maxArrayLength = maxArrayLength;
        this.arrayLengthStep = arrayLengthStep;
        this.iterations = iterations;
        this.resultPathPrefix = resultPathPrefix;
        this.resultPathSuffix = resultPathSuffix;
    }

    public int getMinArrayLength() {
        return this.minArrayLength;
    }

    public int getMaxArrayLength() {
        return this.maxArrayLength;
    }

    public int getArrayLengthStep() {
        return this.arrayLengthStep;
    }

    public int getIterations() {
        return this.iterations;
    }

    public String getResultPathPrefix() {
        return this.resultPathPrefix;
    }

    public String getResultPathSuffix() {
        return this.resultPathSuffix;
    }
}
