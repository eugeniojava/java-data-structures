package com.eugeniomoreira.stack;

class StaticStack<T> implements Stack<T> {
    private final T[] data;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public StaticStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than 0");
        }
        data = (T[]) new Object[size];
    }

    @Override
    public void add(T value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        data[top] = value;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        var value = data[top];
        data[top] = null;
        top--;
        return value;
    }

    @Override
    public boolean isFull() {
        return top == data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
    }
}
