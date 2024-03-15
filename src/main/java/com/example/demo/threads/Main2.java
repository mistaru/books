package com.example.demo.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        PersonThreads threads1 = new PersonThreads();
        List<Person> personList  = new ArrayList<>();
        for (int i = 0;  i < 10; i ++) {
            personList.add(new Person("Person " + i));
        }

        threads1.personList = personList;

        PersonThreads threads2 = new PersonThreads();
        List<Person> personList2  = new ArrayList<>();
        for (int i = 10;  i < 20; i ++) {
            personList2.add(new Person("Person " + i));
        }

        threads2.personList = personList2;

        threads1.start();
        threads2.start();

    }
}
