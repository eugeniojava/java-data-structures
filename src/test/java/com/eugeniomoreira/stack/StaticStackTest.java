package com.eugeniomoreira.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Should throw IllegalArgumentException when the requested size of the stack is invalid")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void test9(int size) {
        final var exception = assertThrows(IllegalArgumentException.class, () -> new StaticStack<>(size));
        assertEquals("Stack size must be greater than 0", exception.getMessage());
    }

    @DisplayName("Should throw IllegalStateException when the stack is full")
    @Test
    void test0() {
        final var element1 = "element1";
        final var element2 = "element2";
        staticStack = new StaticStack<>(1);
        staticStack.add(element1);

        final var exception = assertThrows(IllegalStateException.class, () -> staticStack.add(element2));
        assertEquals("Stack is full", exception.getMessage());
    }

    @DisplayName("Should add one element to the stack")
    @Test
    void test1() {
        final var element = "element";

        staticStack.add(element);

        assertFalse(staticStack.isEmpty());
    }

    @DisplayName("Should throw IllegalStateException when the stack is empty")
    @Test
    void test2() {
        final var exception = assertThrows(IllegalStateException.class, () -> staticStack.remove());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @DisplayName("Should remove the top element of the stack and return it")
    @Test
    void test3() {
        staticStack.add("element1");
        final var element2 = "element2";
        staticStack.add(element2);

        final var result = staticStack.remove();

        assertEquals(element2, result);
    }

    @DisplayName("Should return false when the stack is not full")
    @Test
    void test4() {
        final var result = staticStack.isFull();

        assertFalse(result);
    }

    @DisplayName("Should return true when the stack is full")
    @Test
    void test5() {
        staticStack = new StaticStack<>(1);
        staticStack.add("element");

        final var result = staticStack.isFull();

        assertTrue(result);
    }

    @DisplayName("Should return false when the stack is not empty")
    @Test
    void test6() {
        staticStack.add("element");

        final var result = staticStack.isEmpty();

        assertFalse(result);
    }

    @DisplayName("Should return true when the stack is empty")
    @Test
    void test7() {
        final var result = staticStack.isEmpty();

        assertTrue(result);
    }

    @DisplayName("Should clear the stack")
    @Test
    void test8() {
        staticStack.add("element");

        staticStack.clear();

        assertTrue(staticStack.isEmpty());
    }
}
