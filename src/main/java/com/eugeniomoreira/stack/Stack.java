package com.eugeniomoreira.stack;

interface Stack<T> {
    void clear();

    boolean isEmpty();

    boolean isFull();

    T pop();

    void push(T value);
}
