package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        if (a > b) {
            String res = String.valueOf ( a );
            int maxSize = a;
            StringBuilder result = new StringBuilder ( res );
            for (int i = b; i < maxSize; i++) {
                result.append ( " " + --a );
            }
            return result.toString ();
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            String res = String.valueOf ( a );
            int maxSize = b;
            StringBuilder result = new StringBuilder ( res );
            for (int i = a; i < maxSize; i++) {
                result.append ( " " + ++a );
            }
            return result.toString ();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
//        System.out.println(getAllNumbersBetween(10, 20));
//        System.out.println(getAllNumbersBetween(20, 20));
//        System.out.println(getAllNumbersBetween(20, 30));
    }
}