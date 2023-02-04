package com.eugeniomoreira.stack;

class DynamicStack<T> implements Stack<T> {
    private Node<T> top = null;

    @Override
    public void add(T value) {
        top = new Node<>(value, top);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        var removedValue = top.data;
        top = top.previous;
        return removedValue;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        top = null;
    }

    private record Node<T>(T data, Node<T> previous) {
    }
}
