package com.example.demo.threads;

import java.util.List;

public class PersonThreads extends Thread{
    List<Person> personList;

    @Override
    public void run() {
        for (Person person : personList) {
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("name "  + person.namePerson);
        }
    }
}
