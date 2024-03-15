package com.example.demo.threds2;

import java.util.ArrayList;
import java.util.List;

class Formula1Racer extends Thread {
    private int finishPosition;

    public Formula1Racer(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " started.");
            // Вместо sleep можно использовать другие операции, например, вычисления или случайные задержки.
            sleep((long) (Math.random() * 10000)); // Моделируем время гонки.
            System.out.println(getName() + " finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setFinishPosition(int position) {
        this.finishPosition = position;
    }

    public int getFinishPosition() {
        return finishPosition;
    }
}

public class F1Race {
    public static void main(String[] args) {
        List<Formula1Racer> racers = new ArrayList<>();
        racers.add(new Formula1Racer("Hamilton"));
        racers.add(new Formula1Racer("Verstappen"));
        racers.add(new Formula1Racer("Bottas"));
        racers.add(new Formula1Racer("Leclerc"));
        racers.add(new Formula1Racer("Norris"));

        // Запускаем гонку
        for (Formula1Racer racer : racers) {
            racer.start();
        }

        // Ожидаем завершения всех гонщиков
        for (Formula1Racer racer : racers) {
            try {
                racer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Определяем места
        int position = 1;
        for (Formula1Racer racer : racers) {
            racer.setFinishPosition(position++);
        }

        // Выводим результаты
        racers.sort((r1, r2) -> r1.getFinishPosition() - r2.getFinishPosition());
        System.out.println("Результаты гонки:");
        for (Formula1Racer racer : racers) {
            System.out.println(racer.getName() + " занял " + racer.getFinishPosition() + " место.");
        }
    }
}
