package com.eugeniomoreira.stack;

interface Stack<T> {
    void add(T value);

    T remove();

    boolean isFull();

    boolean isEmpty();

    void clear();
}
