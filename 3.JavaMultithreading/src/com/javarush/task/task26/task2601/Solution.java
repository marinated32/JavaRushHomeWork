package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        double a = 10.0;
//        int b = (int) (a/2);
//        System.out.println (b);
//
//        Integer[] some = new Integer[]{13, 8, 15, 5, 17, 20};
//        sort ( some );
//        System.out.println (Arrays.toString ( some ));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort ( array );
//        System.out.println (Arrays.toString ( array ));

//        Integer[] result = new Integer[array.length];
        int mediana;

//        System.out.println (array.length / 2);
        if (array.length % 2 == 1) {
            mediana = array[array.length / 2];
        } else {
            mediana = ( array[(array.length / 2)] + array[((array.length / 2) - 1 )] ) / 2;
        }

//        System.out.println (mediana);

        Comparator<Integer> comparatorByMediana = new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs ( mediana - o1 ) - Math.abs ( mediana - o2 );
            }
        };

        Arrays.sort ( array, comparatorByMediana );
        return array;
    }
}
