package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream (  );
        PrintStream stream = new PrintStream ( outputStream );
        System.setOut ( stream );

        testString.printSomething ();

        String res = outputStream.toString ();
        System.setOut ( console );

        String adv = "JavaRush - курсы Java онлайн";
        String[] result  = res.split ( "\n" );

        int sum = 0;
//        System.out.println (adv);
        for (int i = 0; i < result.length; i++) {
            if (sum == 2) {
                System.out.println (adv);
                sum = 0;
            }
            System.out.println (result[i]);
            sum++;
//            System.out.println (sum);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
//D:/test.txt