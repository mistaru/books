package com.example.demo.service;
import com.example.demo.rest.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MathUtilsTest {

    @Test
    public void testAddition() {
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.add(3, 5);
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.subtract(10, 7);
        assertEquals(3, result);
    }

    @Test
    public void testDivision() {
        MathUtils mathUtils = new MathUtils();
        double result = mathUtils.divide(10, 2);
        assertEquals(5, result, 0); // Delta is the acceptable difference
    }


}
