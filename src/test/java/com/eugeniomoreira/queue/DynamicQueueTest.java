package com.eugeniomoreira.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicQueueTest {
    private DynamicQueue<String> dynamicQueue;

    @BeforeEach
    void setUp() {
        dynamicQueue = new DynamicQueue<>();
    }

    @Test
    void shouldAddOneElementToTheQueue() {
        final var element = "element";

        dynamicQueue.enqueue(element);

        assertFalse(dynamicQueue.isEmpty());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenTheQueueIsEmpty() {
        final var exception = assertThrows(IllegalStateException.class, () -> dynamicQueue.dequeue());
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    void shouldRemoveTheFrontElementOfTheQueueAndReturnItWhenThereIsJustOneElement() {
        final var element1 = "element1";
        dynamicQueue.enqueue(element1);

        final var result = dynamicQueue.dequeue();

        assertEquals(element1, result);
    }

    @Test
    void shouldRemoveTheFrontElementOfTheQueueAndReturnItWhenThereAreTwoElements() {
        final var element1 = "element1";
        dynamicQueue.enqueue(element1);
        dynamicQueue.enqueue("element2");

        final var result = dynamicQueue.dequeue();

        assertEquals(element1, result);
    }

    @Test
    void shouldRemoveTheFirstFiveElementsOfTheQueueReturningEach() {
        final var element1 = "element1";
        dynamicQueue.enqueue(element1);
        final var element2 = "element2";
        dynamicQueue.enqueue(element2);
        final var element3 = "element3";
        dynamicQueue.enqueue(element3);
        final var element4 = "element4";
        dynamicQueue.enqueue(element4);
        final var element5 = "element5";
        dynamicQueue.enqueue(element5);

        final var result1 = dynamicQueue.dequeue();
        final var result2 = dynamicQueue.dequeue();
        final var result3 = dynamicQueue.dequeue();
        final var result4 = dynamicQueue.dequeue();
        final var result5 = dynamicQueue.dequeue();

        assertEquals(element1, result1);
        assertEquals(element2, result2);
        assertEquals(element3, result3);
        assertEquals(element4, result4);
        assertEquals(element5, result5);
    }

    @Test
    void shouldReturnFalseWhenTheQueueIsNotFull() {
        final var result = dynamicQueue.isFull();

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenTheQueueIsNotEmpty() {
        dynamicQueue.enqueue("element");

        final var result = dynamicQueue.isEmpty();

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenTheQueueIsEmpty() {
        final var result = dynamicQueue.isEmpty();

        assertTrue(result);
    }

    @Test
    void shouldClearTheQueue() {
        dynamicQueue.enqueue("element");

        dynamicQueue.clear();

        assertTrue(dynamicQueue.isEmpty());
    }
}
