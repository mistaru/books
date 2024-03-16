package com.example.demo.threds2;

class Counter {
    private int count = 0;

    public synchronized void increment(String name) {
        int i = count++;
        System.out.println(name + ": " + i);
    }

    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment("thread 1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment("thread 2");
            }
        });

        thread1.setPriority(1);
        thread2.setPriority(10);
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
