package com.example.demo.compare;

import com.example.demo.generics.Human2;

import java.util.Comparator;

public class HumanAgeComparator implements Comparator<Human2> {

    @Override
    public int compare(Human2 first, Human2 second) {
        return Integer.compare(first.getAge(), second.getAge());
    }
}
