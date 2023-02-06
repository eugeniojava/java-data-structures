package com.eugeniomoreira.queue;

class DynamicQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    DynamicQueue() {
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        var removedValue = front.data;
        front = front.next;
        return removedValue;
    }

    @Override
    public void enqueue(T value) {
        var newNode = new Node<>(value, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
