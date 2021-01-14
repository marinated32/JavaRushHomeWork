package com.javarush.task.task19.task1912;

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
        String result = outputStream.toString ();

        System.setOut ( consoleOut );

//        result.replace ( "te", "??" );
        char[] resChar = result.toCharArray ();

        for (int i = 0; i < resChar.length; i++) {
            if (resChar[i] == 't') {
                if (resChar[i+1] == 'e') {
                    resChar[i] = '?';
                    resChar[i+1] = '?';
                }
            }
        }
        String finResult = String.valueOf ( resChar );
        System.out.println (finResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
