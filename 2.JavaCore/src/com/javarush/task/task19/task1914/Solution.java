package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream (  );
        PrintStream stream = new PrintStream ( outputStream );
        System.setOut ( stream );

        testString.printSomething ();

        String[] result = outputStream.toString ().split ( " " );

        System.setOut ( consoleStream );

        int a = Integer.parseInt ( result[0] );
        int b = Integer.parseInt ( result[2] );
        int c = 0;

        switch (result[1]){
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a*b;
                break;
        }

        System.out.println (a +" "+ result[1] +" "+ b +" "+ result[3] +" "+ c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

