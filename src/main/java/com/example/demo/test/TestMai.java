package com.example.demo.test;

public class TestMai {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2,3);
        Square square = new Square(2, 2);

        System.out.println(Shape.square(rectangle));
        System.out.println(Shape.square(square));
    }
}
