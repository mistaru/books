package com.example.demo.innerClass;

interface TrackingSystem {
    void trackLocaltion();
}

interface TrackingSystem2 {
    void trackLocaltion(String local);
}

interface TrackingSystem3 {
    void trackLocaltion(String local, int time);
}

public class Lambda {
    public static void main(String[] args) {
        TrackingSystem gps = new TrackingSystem() {
            @Override
            public void trackLocaltion() {
                System.out.println("Отслеживание началось по GPS");
            }
        };
        gps.trackLocaltion();

        TrackingSystem gps2 = () -> System.out.println("track by Gps");
        TrackingSystem2 gps3 = System.out::println;
        TrackingSystem3 gps4 = (l , t) -> {
            System.out.println(l);
            System.out.println(t);
        };
        gps2.trackLocaltion();
        gps3.trackLocaltion("asdasd");
        gps4.trackLocaltion("asdasd", 3);



        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };
    }


}
