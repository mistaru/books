package com.example.demo.service;

import com.example.demo.service.impl.CodeConfirmServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfirmCodeTest {
    @Test
    public void testGenerateFourDigitNumber(){
        long randomNumber = CodeConfirmServiceImpl.generateFourDigitNumber();
        Assertions.assertEquals(4, String.valueOf(randomNumber).length());
    }

}
