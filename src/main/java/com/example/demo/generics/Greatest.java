package com.example.demo.generics;

import com.example.demo.compare.HumanAgeComparator;
import com.example.demo.compare.HumanNameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Greatest {
    public static <T extends Comparable<T>> T greatest(T x, T y, T z) {
        T max = x; //Пока что, Х максимальное
        if (y.compareTo(max) > 0) {
            max = y; // Значит Y больше X
        }
        if (z.compareTo(max) > 0) {
            max = z; // Значит Z больше всех
        }
        return max;
    }


    public static <T extends Comparable<T>> T greatestArray(T[] arr) {
        T max = arr[0]; //Пока что, Х максимальное
        for (T e : arr) {
            if (e.compareTo(max) > 0)
                max = e; // Значит Z больше всех

        }
        return max;
    }

    public static void main(String[] args) {
        HumanAgeComparator comparatorAge = new HumanAgeComparator();
        HumanNameComparator comparatorName = new HumanNameComparator();

        Human2 h = new Human2(18, 180, "A");
        Human2 h1 = new Human2(20, 170, "B");
        Human2 h2 = new Human2(19, 185, "c");

        List<Human2>  humanList = new ArrayList<>();
        humanList.add(h2);
        humanList.add(h1);
        humanList.add(h);

        for (Human2 human2: humanList) {
            System.out.println(human2.toString());
        }

        humanList.sort(comparatorName);
        System.out.println("-----------------------");
        for (Human2 human: humanList) {
            System.out.println(human.toString());


/*        Human h = new Human(18, 180, "A");
        Human h1 = new Human(20, 170, "B");
        Human h2 = new Human(19, 185, "c");

        List<Human>  humanList = new ArrayList<>();
        humanList.add(h);
        humanList.add(h1);
        humanList.add(h2);

        for (Human human: humanList) {
            System.out.println(human.toString());
        }

        Collections.sort(humanList);
        System.out.println("-----------------------");
        for (Human human: humanList) {
            System.out.println(human.toString());
        }*/
    }
    }
}
