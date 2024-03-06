package com.example.demo.laymbda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        String[] arrayOfStr = {"Alex", "Sam"};
        var asd = Stream.of(arrayOfStr);
        var as = Stream.of(1, 2, 3);

        as.forEach(x -> System.out.println(x * x));
        List<String> list = Arrays.asList(arrayOfStr);

    }

}
