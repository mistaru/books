package com.example.demo.innerClass;

class Animal {
    public void eat() {
        System.out.println("Я Животное и я могу кушать");
    }
}

interface AbleToEat {
    void eat();
}

class Animal2 implements AbleToEat {

    @Override
    public void eat() {
        System.out.println("Я кровожадно съедаю пищу");
    }
}

class Human implements AbleToEat {

    @Override
    public void eat() {
        System.out.println("Я культурно поедаю салат");
    }
}

public class  Main {
    public static void main(String[] args) {
        ElectroCar electroCar = new ElectroCar();
        electroCar.start();

        ElectroCar.Battery battery = new ElectroCar.Battery();
        battery.start();


        new Animal().eat();


        new Animal() {
            @Override
            public void eat() {
                System.out.println("Я другое животное и я могу кушать ");
                ;
            }
        }.eat();

        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("Я анонимный класс и я тоже умею кушать ");
            }
        };

        ableToEat.eat();
    }
}