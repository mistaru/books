package com.example.demo.innerClass;

@FunctionalInterface
interface AnonymousInterface {
    void printAnonymous ();
}

class OtherClass {
    public void print() {
        System.out.println("Я обычный класс!    ");
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        OtherClass otherClass = new OtherClass();
        otherClass.print();

        OtherClass anonymousClass = new OtherClass() {
            public void print() {
                System.out.println("Я анонимный класс!");
            }
        };

        anonymousClass.print();

        AnonymousInterface anonymousInterface = new AnonymousInterface() {
            @Override
            public void printAnonymous() {
                System.out.println("Я тоже анонимный класс");
            }
        };

        anonymousInterface.printAnonymous();
    }

}
