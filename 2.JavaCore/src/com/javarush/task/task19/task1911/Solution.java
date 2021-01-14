package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream (  );
        PrintStream stream = new PrintStream ( outputStream );
        System.setOut ( stream );

        testString.printSomething ();

        String result = outputStream.toString ().toUpperCase ();

        System.setOut ( consoleOut );
        System.out.println (result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
