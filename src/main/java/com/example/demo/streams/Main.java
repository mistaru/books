package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //1 вариант
        System.out.println("count");
        String[] arrayOfStr = {"Alex", "Sam", "asdasd",  "as"};
        System.out.println(Stream.of(arrayOfStr).filter(s -> s.length() > 3).count());
        Stream.of(1.12, 2.1231, 3.123);

        //2 вариант
        List<String> list = Arrays.asList(arrayOfStr);
        list.stream();

        System.out.println("---------------1");
        for (int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }

        System.out.println("---------------2");
        for (String string: list) {
            System.out.println(string);
        }

        System.out.println("---------------3");
        list.forEach(s-> System.out.println(s));
        System.out.println("---------------");

        System.out.println("---------------4");
        list.forEach(System.out::println);

        System.out.println("Создать массив из чисел. Вывести в стриме каждый элемент в квадрате (a*a).\n");

        var intStreams = Stream.of(1, 2, 3);
        intStreams.forEach(i -> System.out.println(Math.pow(i, 2)));


        System.out.println("Создать список строчных элементов. Вывести элементы заменив в строке букву «а»  на  «о»\n");
        String[] apple = {"a", "p", "p", "l", "e"};
        Stream.of(apple).forEach(s -> {
            if (s.equals("a")) s = "o";
            System.out.print(s);
        });

        System.out.println();
        Stream.of(apple).forEach(s -> System.out.print(s.equals("a") ? "o" : s));
        System.out.println();


        System.out.println("map and collect");
        Student[] studentList = {new Student("A"), new Student("B"), new Student("C")};
        var streamStudentList = Stream.of(studentList);
        List<String> studNamesList = streamStudentList.map(Student::getName).toList();
        studNamesList.forEach(System.out::println);


        System.out.println();
        System.out.println("filter");

        Stream.of(1, 23, 2, 123, 1123, 1231)
                .filter(x -> x > 100)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Min");
        Stream.of(1, 12, 2, 123, 1123, 1231, 1231).min(Integer::compare).ifPresent(System.out::println);


    }

}
