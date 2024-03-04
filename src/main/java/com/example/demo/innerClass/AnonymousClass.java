package com.example.demo.innerClass;

@FunctionalInterface
interface AnonymousInterface {
    void printAnonymous ();
}

@FunctionalInterface
interface AnonymousInterface2 {
    int printAnonymous (int a, int b);
}

class OtherClass {
    public void print(int a) {
        System.out.println("Я обычный класс!   со значением " + a );
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        OtherClass otherClass = new OtherClass();
        otherClass.print(21);

        OtherClass anonymousClass = new OtherClass() {
            public void print(int a) {
                System.out.println("Я анонимный класс! со значением "  + a);
            }
        };

        anonymousClass.print(21);

        AnonymousInterface anonymousInterface = new AnonymousInterface() {
            @Override
            public void printAnonymous() {
                System.out.println("Я тоже анонимный класс");
            }
        };

        AnonymousInterface2 anonymousInterface21 = new AnonymousInterface2() {
            @Override
            public int printAnonymous(int a, int b ) {
                return a * b;
            }
        };

        AnonymousInterface2 anonymousInterface22 = (a, b) -> a / b;

        AnonymousInterface anonymousInterface2 = () -> System.out.println("Я тоже анонимный класс");

        AnonymousInterface anonymousInterface1 = () -> System.out.println("asdasd");
        AnonymousInterface anonymousInterface3 = () -> System.out.println("asdasd");

        anonymousInterface.printAnonymous();


        new Thread(() -> System.out.println("Анонимный вызов")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Анонимный вызов");
            }
        }).start();

    }

}
