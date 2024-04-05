package com.example.demo.rest;

public class ATM {
    private static final int[] denominations = {100, 200, 500, 1000};

    public static void checkBalance(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < 5) {
                System.out.println("Мало купюр номинала " + denominations[i] + ", надо пополнить");
            }
        }

        int maxCount = counts[0];
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        for (int count : counts) {
            if (maxCount > count * 2) {
                System.out.println("Перекос");
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Пример использования
        int[] counts = {10, 20, 15, 32};
        checkBalance(counts);
    }
}
