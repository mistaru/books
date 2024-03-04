package com.example.demo.laymbda;

public class Main {
    static  int nb = 4;
    public static void main(String[] args) {

        AnotherInterface anotherInterface = new AnotherInterface() {
            @Override
            public String example(String name, int age) {
                return "Name: " + name + ", age: " + age ;
            }
        };
        System.out.println(anotherInterface.example("Argen", 27));

         int  i = 5;

        AnotherInterface anotherInterfaceLyambda = (n, a) -> "Name: " + n + ", age: " + i;


        System.out.println(anotherInterfaceLyambda.example("Argen", 27));
    }

}
