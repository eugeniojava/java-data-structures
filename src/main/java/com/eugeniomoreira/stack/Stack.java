package com.eugeniomoreira.stack;

public interface Stack<T> {
    void add(T value);

    T remove();

    boolean isFull();

    boolean isEmpty();

    void clear();
}
