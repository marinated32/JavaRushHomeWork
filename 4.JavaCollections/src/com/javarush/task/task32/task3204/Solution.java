package com.javarush.task.task32.task3204;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream result = new ByteArrayOutputStream (  );

        result.write ( 48 + (int) (Math.random ()*10) );
        result.write ( 65 + (int) (Math.random ()*25) );
        result.write ( 97 + (int) (Math.random ()*25) );

        for (int i = 0; i < 5; i++) {
            double move = Math.random ();
            int currentChar;
            if (move < 0.333) {
                currentChar = 48 + (int) (Math.random ()*10);
            }else if (move < 0.666) {
                currentChar = 65 + (int) (Math.random ()*25);
            } else {
                currentChar = 97 + (int) (Math.random ()*25);
            }
//            System.out.println (currentChar);
//            System.out.println (move);
            result.write ( currentChar );
        }


//        char a = new char(30);
//        int[] digit = new int[10];
//        for (int i = 0; i < 10; i++) {
//            digit[i] = i+48;
//        }
//        int[] bigLetter = new int[25];
//        for (int i = 0; i < 25; i++) {
//            bigLetter[i] = i+65;
//        }
//        int[] smallLetter = new int[25];
//        for (int i = 0; i < 25; i++) {
//            smallLetter[i] = i+97;
//        }
        return result;
    }
}
