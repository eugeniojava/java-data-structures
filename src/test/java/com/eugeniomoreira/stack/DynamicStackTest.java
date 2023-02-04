package com.eugeniomoreira.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Should add one element to the stack")
    @Test
    void test1() {
        final var element = "element";

        dynamicStack.add(element);

        assertFalse(dynamicStack.isEmpty());
    }

    @DisplayName("Should throw IllegalStateException when the stack is empty")
    @Test
    void test2() {
        final var exception = assertThrows(IllegalStateException.class, () -> dynamicStack.remove());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @DisplayName("Should remove the top element of the stack and return it")
    @Test
    void test3() {
        dynamicStack.add("element1");
        final var element2 = "element2";
        dynamicStack.add(element2);

        final var result = dynamicStack.remove();

        assertEquals(element2, result);
    }

    @DisplayName("Should return false when the stack is not full")
    @Test
    void test4() {
        final var result = dynamicStack.isFull();

        assertFalse(result);
    }

    @DisplayName("Should return false when the stack is not empty")
    @Test
    void test6() {
        dynamicStack.add("element");

        final var result = dynamicStack.isEmpty();

        assertFalse(result);
    }

    @DisplayName("Should return true when the stack is empty")
    @Test
    void test7() {
        final var result = dynamicStack.isEmpty();

        assertTrue(result);
    }

    @DisplayName("Should clear the stack")
    @Test
    void test8() {
        dynamicStack.add("element");

        dynamicStack.clear();

        assertTrue(dynamicStack.isEmpty());
    }
}
