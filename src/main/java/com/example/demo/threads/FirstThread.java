package com.example.demo.threads;

public class FirstThread extends  Thread {
    @Override
    public void run() {
        System.out.println("This is first thread");
    }

    public static void main(String[] args) {
        FirstThread fs = new FirstThread();
        FirstThread fs2 = new FirstThread();
        fs.start();
        fs2.start();
        System.out.println("Main thread, main");
    }
}