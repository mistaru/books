package com.example.demo.innerClass;

public class MainLocal {
    A a = new A();
    A.B b = a.new B();


   A.D d  = new A.D();
   A.D d2  = A.D.createD();
}
