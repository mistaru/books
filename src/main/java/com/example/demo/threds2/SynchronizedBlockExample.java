package com.example.demo.threds2;

class Counter3 {
    private int count = 0;

    public void increment(String name) {
        int i = count++;
        System.out.println(name + ": " + i);
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        Counter3 counter = new Counter3();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (counter) {
                    counter.increment("1");
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим значение счетчика
        System.out.println("Счетчик: " + counter.getCount()); // Должно вывести 2000
    }
}
