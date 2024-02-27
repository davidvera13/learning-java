package io.warehouse13.learning;

@FunctionalInterface
public interface Operation<T> {
    T operate(T val1, T val2);
}
