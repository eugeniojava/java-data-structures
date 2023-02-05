package com.eugeniomoreira.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularQueueTest {
    private CircularQueue<String> circularQueue;

    @BeforeEach
    void setUp() {
        circularQueue = new CircularQueue<>(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldThrowIllegalArgumentExceptionWhenTheRequestedSizeOfTheQueueIsInvalid(int size) {
        final var exception = assertThrows(IllegalArgumentException.class, () -> new CircularQueue<>(size));
        assertEquals("Queue size must be greater than 0", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenTheQueueIsFull() {
        circularQueue = new CircularQueue<>(1);
        circularQueue.enqueue("element1");

        final var exception = assertThrows(IllegalStateException.class, () -> circularQueue.enqueue("element2"));
        assertEquals("Queue is full", exception.getMessage());
    }

    @Test
    void shouldAddOneElementToTheQueue() {
        final var element = "element";

        circularQueue.enqueue(element);

        assertFalse(circularQueue.isEmpty());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenTheQueueIsEmpty() {
        final var exception = assertThrows(IllegalStateException.class, () -> circularQueue.dequeue());
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    void shouldRemoveTheFrontElementOfTheQueueAndReturnItWhenThereIsJustOneElement() {
        final var element1 = "element1";
        circularQueue.enqueue(element1);

        final var result = circularQueue.dequeue();

        assertEquals(element1, result);
    }

    @Test
    void shouldRemoveTheFrontElementOfTheQueueAndReturnItWhenThereAreTwoElements() {
        final var element1 = "element1";
        circularQueue.enqueue(element1);
        circularQueue.enqueue("element2");

        final var result = circularQueue.dequeue();

        assertEquals(element1, result);
    }

    @Test
    void shouldReturnFalseWhenTheQueueIsNotFull() {
        final var result = circularQueue.isFull();

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenTheQueueIsFull() {
        circularQueue = new CircularQueue<>(1);
        circularQueue.enqueue("element");

        final var result = circularQueue.isFull();

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenTheQueueIsNotEmpty() {
        circularQueue.enqueue("element");

        final var result = circularQueue.isEmpty();

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenTheQueueIsEmpty() {
        final var result = circularQueue.isEmpty();

        assertTrue(result);
    }

    @Test
    void shouldClearTheQueue() {
        circularQueue.enqueue("element");

        circularQueue.clear();

        assertTrue(circularQueue.isEmpty());
    }
}
