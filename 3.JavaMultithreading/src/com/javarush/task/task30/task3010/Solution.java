package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        System.out.println (Integer.toString ( Integer.parseInt ( "12AS08z" ), 36) );

        for (int i = 2; i < 37; i++) {
            try {
                BigInteger num = new BigInteger ( args[0] , i );
                System.out.println (i);
                return;
            } catch (Exception e) {
            }
        }
        System.out.println ("incorrect");
    }
}