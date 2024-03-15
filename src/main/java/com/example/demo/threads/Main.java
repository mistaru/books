package com.example.demo.threads;

class Student2 implements Runnable {
    public String nameStudent;

    @Override
    public void run() {
        System.out.println("Student2 - thread: " + this.nameStudent);

    }
}

class Student extends Thread {
    private String nameStudent;


    public void run() {
        System.out.println("Student - thread: " + this.nameStudent);
    }


    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameStudent("Oleg");
        student.start();

        Student2 student2 = new Student2();
        student2.nameStudent = "Oleg2";
        Thread thread = new Thread(student2);
        thread.start();
    }
}

