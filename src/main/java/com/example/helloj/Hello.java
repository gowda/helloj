package com.example.helloj;

import java.util.Scanner;

public class Hello {
    private static final String TEMPLATE = "hello, %s!";
    private static final String DEFAULT_SUBJECT = "world";

    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            System.out.print("Please enter your name: ");
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            String line = scanner.nextLine();
            String name = line.replaceAll("^\\s+", "")
                .replaceAll("\\s+$", "")
                .replaceAll("\\s+", " ");
            if (name.length() == 0) {
                name = DEFAULT_SUBJECT;
            }

            String hello = String.format(TEMPLATE, name);
            System.out.println(hello);
        } finally {
            scanner.close();
        }
    }
}
