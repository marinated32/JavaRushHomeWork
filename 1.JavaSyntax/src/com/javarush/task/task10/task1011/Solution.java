package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        char[] array = s.toCharArray();

        for (int i = 0; i < 40; i++) {
            System.out.println ( Arrays.copyOfRange( array, i, array.length ) );
        }

    }

}

