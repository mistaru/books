package com.example.demo.innerClass;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class A {
    private String name;
    public class B {
        public void print() {
            System.out.println(name);
            System.out.println(getName());
        }
    }

    public class C {
        void set(String name) {
           setName(name);
            System.out.println(getName());
        }

        public void localClass() {
            class LocalClass {
                static final String name2 = "null";
                void print() {
                    System.out.println("Я внутренний локальный класс");
                    set("ASDASDASD");
                    name = "asdasdas";
                }
            }

            LocalClass localClass = new LocalClass();
            localClass.print();
        }
    }

    public static class D {

        public static D createD() {
            return new D();
        }
    }

}
