package com.example.demo.threds2;

class Counter3 {
    private int count = 0;

    public void increment() {
        count++;
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
                // Блок синхронизации для обеспечения безопасности доступа к счетчику
                synchronized (counter) {
                    counter.increment();
                }
            }
        };

        // Создаем и запускаем несколько потоков
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
