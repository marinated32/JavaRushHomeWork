package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put ( 0, "ноль" );
        map.put ( 1, "один" );
        map.put ( 2, "два" );
        map.put ( 3, "три" );
        map.put ( 4, "четыре" );
        map.put ( 5, "пять" );
        map.put ( 6, "шесть" );
        map.put ( 7, "семь" );
        map.put ( 8, "восемь" );
        map.put ( 9, "девять" );
        map.put ( 10, "десять" );
        map.put ( 11, "одиннадцать" );
        map.put ( 12, "двенадцать" );
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileName = reader.readLine ();
        reader.close ();

        List<String> result = new ArrayList<>();

        FileReader fileReader = new FileReader ( fileName );
        Scanner scanner = new Scanner ( fileReader );
        while (scanner.hasNext ()) {
            result.add ( scanner.nextLine () );
        }
        fileReader.close ();

        int i = -1;
//        System.out.println (result);

        for (String res: result) {
            String[] part = res.split ( " " );
            for (String str: part) {
                try {
                    i = Integer.parseInt ( str );
                } catch (NumberFormatException e) { }

                try {
                    if (map.containsKey ( i )) {
                        str = map.get ( Integer.parseInt ( str ) );
                    }
                } catch (NumberFormatException e) { }
                System.out.print (str + " ");
            }
            System.out.println ();
        }
    }
}
//D:/test.txt