package com.javarush.task.task14.task1420;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

        String line1 = reader.readLine ();
        String line2 = reader.readLine ();
        reader.close ();

        int num1 = convert( line1 );
        int num2 = convert ( line2 );

//        System.out.println ( getSimpleNumbers ( num1 ) );
//        System.out.println ( getSimpleNumbers ( num2 ) );
        System.out.println ( NOD(num1, num2) );
    }

    public static int NOD(int num1, int num2) {
        int result = 1;

        List<Integer> listNum1;
        List<Integer> listNum2;
        List<Integer> resultList;

        if (num1 == num2)
            result = num1;
        else if (num1 % num2 == 0)
            result = num2;
        else if (num2 % num1 == 0)
            result = num1;
        else {
            listNum1 = getSimpleNumbers ( num1 );
            listNum2 = getSimpleNumbers ( num2 );
            if (!(Collections.disjoint ( listNum1, listNum2 ))) {
                resultList = new ArrayList<> ( listNum1 );
                resultList.retainAll ( listNum2 );
                result = Collections.max ( resultList );
            }
        }
        return result;
    }

    public static List<Integer> getSimpleNumbers(int num) {
        List<Integer> list = new ArrayList<> (  );

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                if (!(list.contains ( i )))
                    list.add(i);
            }
        }
        return list;
    }

    private static int convert(String str) throws Exception {
        if (Integer.parseInt ( str ) <= 0) {
            throw new NumberFormatException ( " не подходит " );
        }
        return Integer.parseInt ( str );
    }
}
