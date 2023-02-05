package com.eugeniomoreira.stack;

class StaticStack<T> implements Stack<T> {
    private final T[] data;
    private int top;

    @SuppressWarnings("unchecked")
    StaticStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than 0");
        }
        data = (T[]) new Object[size];
        top = -1;
    }

    @Override
    public void clear() {
        for (var i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == data.length - 1;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        var removedValue = data[top];
        data[top] = null;
        top--;
        return removedValue;
    }

    @Override
    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        data[top] = value;
    }
}
