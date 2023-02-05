package com.eugeniomoreira.stack;

class DynamicStack<T> implements Stack<T> {
    private Node<T> top;

    DynamicStack() {
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        var removedValue = top.data;
        top = top.previous;
        return removedValue;
    }

    @Override
    public void push(T value) {
        top = new Node<>(value, top);
    }

    private record Node<T>(T data, Node<T> previous) {
    }
}
