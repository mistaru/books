package com.example.demo.rest;

interface Display {
    void show(String message);
}

class Monitor implements Display {
    @Override
    public void show(String message) {
        System.out.println("Монитор от компа: " + message);
    }
}

class Printer implements Display {
    @Override
    public void show(String message) {
        System.out.println("Дисплей на принтере: " + message);
    }
}

class MessageDisplay {
    private final Display display;

    public MessageDisplay(Display display) {
        this.display = display;
    }

    public void displayMessage(String message) {
        display.show(message);
    }
}

public class Main {
    public static void main(String[] args) {
        MessageDisplay monitorDisplay = new MessageDisplay(new Monitor());
        monitorDisplay.displayMessage("Привет, мир!");

        MessageDisplay printerDisplay = new MessageDisplay(new Printer());
        printerDisplay.displayMessage("Печатает документ: страница...");
    }
}
