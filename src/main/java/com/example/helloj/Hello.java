package com.example.helloj;

import java.util.Scanner;

public class Hello {
    private static final String TEMPLATE = "hello, %s!";
    private static final String DEFAULT_SUBJECT = "world";

    public String askName() {
        String name = null;
        Scanner scanner = null;

        try {
            System.out.print("Please enter your name: ");
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            String line = scanner.nextLine();
            name = line.replaceAll("^\\s+", "")
                    .replaceAll("\\s+$", "")
                    .replaceAll("\\s+", " ");
        } finally {
            scanner.close();
        }

        return name;
    }

    public void sayHello(String name) {
        String subject;
        if (name == null || name.length() == 0) {
            subject = DEFAULT_SUBJECT;
        } else {
            subject = name;
        }

        String hello = String.format(TEMPLATE, subject);
        System.out.println(hello);
    }
}
