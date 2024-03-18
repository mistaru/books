package com.example.demo.rest;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
