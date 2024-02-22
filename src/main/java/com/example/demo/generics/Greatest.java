package com.example.demo.generics;

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
        System.out.printf("Крупнейшее из %d, %d и %d это %d",
                3, 4, 5, greatest(3L, 4L, 5L));
        System.out.printf("\n\nКрупнейшее из %.1f, %.1f и %.1f это %.1f",
                3.3, 3.3, 5.5, greatest(3.3, 4.4, 5.5));
        System.out.printf("\n\nКрупнейшее из %s, %s и %s это %s",
                "шапка", "куртка", "туфли",
                greatest("шапка", "куртка", "туфли"));
        System.out.println();

        Human h = new Human();
        Human h1 = new Human();
        Human h2 = new Human();

        System.out.println(greatestArray(new Integer[] {1, 23,412,1231}));
    }
}
