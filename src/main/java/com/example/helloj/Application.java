package com.example.helloj;

import com.example.hello.Hello;

public class Application {
    public static void main(String[] args) {
        Hello hello = new Hello();

        String name = hello.askName();

        hello.sayHello(name);
    }
}
