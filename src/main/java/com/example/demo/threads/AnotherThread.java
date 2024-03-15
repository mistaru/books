package com.example.demo.threads;

public class AnotherThread implements Runnable {
    @Override
    public void run() {
        System.out.println("This is first thread");
    }

    public static void main (String[] args) {
        Thread t = new Thread(new AnotherThread());
        t.start();
        System.out.println("Main thread, main");
    }
}