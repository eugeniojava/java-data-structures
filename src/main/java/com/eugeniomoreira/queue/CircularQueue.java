package com.eugeniomoreira.queue;

import java.util.Arrays;

class CircularQueue<T> implements Queue<T> {
    private final T[] data;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    CircularQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue size must be greater than 0");
        }
        data = (T[]) new Object[size];
        front = -1;
        rear = 0;
    }

    @Override
    public void clear() {
        front = -1;
        rear = 0;
        setAllValuesToNull();
    }

    private void setAllValuesToNull() {
        Arrays.fill(data, null);
    }

    @Override
    public void enqueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        front = getNextPosition(front);
        data[front] = value;
    }

    private int getNextPosition(int position) {
        return position + 1 == data.length ? 0 : position + 1;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T removedValue = data[rear];
        removeFirstValue();
        return removedValue;
    }

    private void removeFirstValue() {
        if (front == rear) {
            clear();
            return;
        }
        data[rear] = null;
        rear = getNextPosition(rear);
    }

    @Override
    public boolean isFull() {
        return !isEmpty() && getNextPosition(front) == rear;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }
}
