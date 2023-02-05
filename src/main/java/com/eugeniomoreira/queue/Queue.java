package com.eugeniomoreira.queue;

interface Queue<T> {
    void clear();

    T dequeue();

    void enqueue(T value);

    boolean isEmpty();

    boolean isFull();
}
