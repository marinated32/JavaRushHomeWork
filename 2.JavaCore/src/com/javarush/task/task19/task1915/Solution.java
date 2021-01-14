package com.javarush.task.task19.task1915;

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileName = reader.readLine ();
        reader.close ();

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream (  );
        PrintStream stream = new PrintStream ( outputStream );
        System.setOut ( stream );

        testString.printSomething ();

        String result = outputStream.toString ();
        System.setOut ( consoleStream );

        System.out.println (result);

        FileOutputStream outputStream1 = new FileOutputStream ( fileName );
        outputStream1.write ( result.getBytes () );
        outputStream1.close ();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
//D:/result.txt
