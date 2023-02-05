package com.eugeniomoreira.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicStackTest {
    private DynamicStack<String> dynamicStack;

    @BeforeEach
    void setUp() {
        dynamicStack = new DynamicStack<>();
    }

    @Test
    void shouldAddOneElementToTheStack() {
        final var element = "element";

        dynamicStack.push(element);

        assertFalse(dynamicStack.isEmpty());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenTheStackIsEmpty() {
        final var exception = assertThrows(IllegalStateException.class, () -> dynamicStack.pop());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void shouldRemoveTheTopElementOfTheStackAndReturnIt() {
        dynamicStack.push("element1");
        final var element2 = "element2";
        dynamicStack.push(element2);

        final var result = dynamicStack.pop();

        assertEquals(element2, result);
    }

    @Test
    void shouldReturnFalseWhenTheStackIsNotFull() {
        final var result = dynamicStack.isFull();

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenTheStackIsNotEmpty() {
        dynamicStack.push("element");

        final var result = dynamicStack.isEmpty();

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenTheStackIsEmpty() {
        final var result = dynamicStack.isEmpty();

        assertTrue(result);
    }

    @Test
    void shouldClearTheStack() {
        dynamicStack.push("element");

        dynamicStack.clear();

        assertTrue(dynamicStack.isEmpty());
    }
}
