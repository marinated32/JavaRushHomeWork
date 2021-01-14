package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
//        System.out.println (fileName);
        Map<String, Double> result = new TreeMap<> ();

        FileReader reader = new FileReader ( fileName );
        BufferedReader scanner = new BufferedReader ( reader );

        while (scanner.ready ()) {
            String line = scanner.readLine ();
            String[] res = line.split ( " " );
//            System.out.println ( res[0] + " " + res[1]);
//            System.out.println ( line );
            if (result.containsKey ( res[0] )) {
                result.put ( res[0], result.get ( res[0] ) + Double.valueOf ( res[1] ) );
            }else {
                result.put ( res[0], Double.parseDouble ( res[1] ) );
            }
        }
        reader.close ();

        for (Map.Entry<String, Double> res: result.entrySet ()) {
            System.out.println (res.getKey () + " " + res.getValue ());
        }
    }
}
