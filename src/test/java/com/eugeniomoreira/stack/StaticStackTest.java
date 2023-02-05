package com.eugeniomoreira.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StaticStackTest {
    private StaticStack<String> staticStack;

    @BeforeEach
    void setUp() {
        staticStack = new StaticStack<>(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldThrowIllegalArgumentExceptionWhenTheRequestedSizeOfTheStackIsInvalid(int size) {
        final var exception = assertThrows(IllegalArgumentException.class, () -> new StaticStack<>(size));
        assertEquals("Stack size must be greater than 0", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenTheStackIsFull() {
        staticStack = new StaticStack<>(1);
        staticStack.push("element1");

        final var exception = assertThrows(IllegalStateException.class, () -> staticStack.push("element2"));
        assertEquals("Stack is full", exception.getMessage());
    }

    @Test
    void shouldAddOneElementToTheStack() {
        final var element = "element";

        staticStack.push(element);

        assertFalse(staticStack.isEmpty());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenTheStackIsEmpty() {
        final var exception = assertThrows(IllegalStateException.class, () -> staticStack.pop());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void shouldRemoveTheTopElementOfTheStackAndReturnIt() {
        staticStack.push("element1");
        final var element2 = "element2";
        staticStack.push(element2);

        final var result = staticStack.pop();

        assertEquals(element2, result);
    }

    @Test
    void shouldReturnFalseWhenTheStackIsNotFull() {
        final var result = staticStack.isFull();

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenTheStackIsFull() {
        staticStack = new StaticStack<>(1);
        staticStack.push("element");

        final var result = staticStack.isFull();

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenTheStackIsNotEmpty() {
        staticStack.push("element");

        final var result = staticStack.isEmpty();

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenTheStackIsEmpty() {
        final var result = staticStack.isEmpty();

        assertTrue(result);
    }

    @Test
    void shouldClearTheStack() {
        staticStack.push("element");

        staticStack.clear();

        assertTrue(staticStack.isEmpty());
    }
}
