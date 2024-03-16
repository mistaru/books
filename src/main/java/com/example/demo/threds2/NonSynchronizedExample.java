package com.example.demo.threds2;

class Counter2 {
    private int count = 0;

    public void increment(String name) {
        int i = count++;
        System.out.println(name + ": " + i);
    }

    public int getCount() {
        return count;
    }
}

public class NonSynchronizedExample {
    public static void main(String[] args) {
        Counter2 counter = new Counter2();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment("1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment("2");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Счетчик: " + counter.getCount());
    }
}
