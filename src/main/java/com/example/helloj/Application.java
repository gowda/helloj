package com.example.helloj;

public class Application {
    public static void main(String[] args) {
        Hello hello = new Hello();

        String name = hello.askName();

        hello.sayHello(name);
    }
}
