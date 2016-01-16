package com.example.hello;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class HelloTest {
    private static final String TEST_NAME = "test-name";
    byte nameByteArray[] = TEST_NAME.getBytes();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(nameByteArray);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void askNameShouldPromptUser() {
        Hello hello = new Hello();

        hello.askName();

        assertEquals("Please enter your name: ", outContent.toString());
    }

    @Test
    public void askNameShouldReturnUserInput() {
        Hello hello = new Hello();

        String name = hello.askName();

        assertEquals(TEST_NAME, name);
    }

    @Test
    public void askNameShouldStripSpaces() {
        String spacedName = "  test   name   ";
        byte spacedNameBytes[] = spacedName.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(spacedNameBytes);
        System.setIn(inputStream);

        Hello hello = new Hello();
        String name = hello.askName();

        assertEquals("test name", name);
    }

    @Test
    public void sayHelloShouldPrintMessage() {
        Hello hello = new Hello();

        hello.sayHello("some name");

        assertEquals("hello, some name!\n", outContent.toString());
    }
}
