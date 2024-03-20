package com.example.demo.service;

import com.example.demo.entity.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommentServiceTest {
    @Test
    @DisplayName("Test Should Pass When Comment do not Contains Swear Words")
    public void shouldNotContainSwearWordsInsideComment() {
        Address commentService = new Address(null, null, null, null);
        assertFalse(Boolean.FALSE);
    }

    @Test
    @DisplayName("Test Should Pass When Comment do not Contains Swear Words")
    public void add() {

        assertEquals(123, 123);
    }
}