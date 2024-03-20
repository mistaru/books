package com.example.demo.test;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Shape {
    int length;
    int weight;


    public static int square (Shape shape) {
        return shape.length * shape.weight;
    }
}
