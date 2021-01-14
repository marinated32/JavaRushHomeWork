package com.javarush.task.task20.task2025;

import java.util.ArrayList;
//import java.util.ArrayUtils;
import java.util.Arrays;
import java.util.List;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[] res = null;
        if (N <= 0 || N > Long.MAX_VALUE)
            return res;

        List<Long> result = new ArrayList<> (  );
        List<Long> simpleNum = new ArrayList<> (  );
        int m = 0;
        long sum = 0l;

        for (long i = 1; i < N; i++) {
            long k = i;
            while (k > 0) {
                simpleNum.add ( k%10 );
                k = k/10;
                m++;
            }
            for (Long num: simpleNum) {
                sum += (long) Math.pow ( num, m );
            }

            if (i == sum) {
                result.add ( i );
            }
            m = 0;
            sum = 0l;
            simpleNum.clear ();
        }

        res = new long[result.size()];
        for (int i = 0; i < result.size (); i++) {
            res[i] = result.get ( i );
        }
        result.clear ();
        return res;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
