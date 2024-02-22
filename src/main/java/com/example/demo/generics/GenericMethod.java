package com.example.demo.generics;

public class GenericMethod {
    public static<T> void printArr(T[] arr) {
        for(T element : arr){
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    public static void main(String... args) {
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3};
        Character[] charArray = {'H','E','L','L','o'};
        System.out.println("Integer Array: ");
        printArr(intArray);
        System.out.println("Double Array: ");
        printArr(doubleArray);
        System.out.println("Character Array: ");
        printArr(charArray);
    }
}
