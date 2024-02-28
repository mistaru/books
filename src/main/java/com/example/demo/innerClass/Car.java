package com.example.demo.innerClass;


class Engine {
    public void start(){
        System.out.println("Двигатель запущен!");
    }
}

public class Car {

    public static void main(String[] args) {
        Engine engine = new Engine();

        engine.start();
    }
}
