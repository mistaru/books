package com.example.demo.generics;

public class GenericMethod {
    public static<T> void printArr(T[] arr) {
        for(T element : arr){
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    public static void main(String... args) {


    }
}
