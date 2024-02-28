package com.example.demo.innerClass;

public class ElectroCar {

    public class Motor {
        public void start() {
            System.out.println("Motor is start!");
        }
    }
    public void start () {
        Motor motor = new Motor();
        motor.start();
        System.out.println("Electrocar is start!");

        class SomeClass {
            void start() {
                System.out.println("Я внутренний локальный класс");
            }
        }

        SomeClass a = new SomeClass();
        a.start();
        test(a);
    }

    public static class Battery {
        public void start() {
            System.out.println("I am battery!");
        }
    }

    public void test(Object obj) {

    }

}
