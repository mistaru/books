package com.example.demo.threads;

import java.util.List;

public class Person extends Thread {
    public String namePerson;


    public Person(String namePerson) {
        this.namePerson = namePerson;
    }


}
