package com.sorting.demonstration.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CacheArraysFactory implements ArraysFactory {

    private final Map<Key, int[]> cache = new HashMap<>();
    private final ArraysFactory arraysFactory;

    public CacheArraysFactory(final ArraysFactory arraysFactory) {
        this.arraysFactory = arraysFactory;
    }

    @Override
    public int[] create(final int length) {
        final Key key = new Key(length);
        int[] array = this.cache.get(key);
        if (isEmpty(array)) {
            array = this.arraysFactory.create(length);
            this.cache.put(key, array);
        }
        return array;
    }

    private boolean isEmpty(final int[] array) {
        return (array == null) || (array.length == 0);
    }

    private final class Key {

        private final int value;

        Key(final int value) {
            this.value = value;
        }

        @Override
        public boolean equals(final Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            final Key other = (Key) object;
            return (this.value == other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }
    }
}
