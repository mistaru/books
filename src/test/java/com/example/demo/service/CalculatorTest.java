package com.example.demo.service;

import com.example.demo.rest.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

@DisplayName("описание таска")
public class CalculatorTest {
    @Test
    public void testCalculatorAdd() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(23, calculator.add(21,2));
    }
}