package com.eugeniomoreira.stack;

public class DynamicStack<T> implements Stack<T> {
    private Node<T> top = null;

    @Override
    public void add(T value) {
        var newNode = new Node<T>();
        newNode.data = value;
        newNode.previous = top;
        top = newNode;
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

    private static class Node<T> {
        private T data;
        private Node<T> previous;
    }
}
