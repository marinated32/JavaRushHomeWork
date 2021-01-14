package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];

        Map<String, Double> map = new TreeMap<> (  );

        FileReader fileReader = new FileReader ( file );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );

        while (bufferedReader.ready ()) {
            String line = bufferedReader.readLine ();
            String[] res = line.split ( " " );
            if (map.containsKey ( res[0] )) {
                map.replace ( res[0], map.get ( res[0] ) + Double.parseDouble ( res[1] ) );
            }else {
                map.put ( res[0], Double.parseDouble ( res[1] ) );
            }
        }fileReader.close ();

        Double maxValue = Collections.max ( map.values () );

        for (Map.Entry<String, Double> pair: map.entrySet ()) {
            if (pair.getValue ().equals ( maxValue )) {
                System.out.println (pair.getKey ());
            }
        }

    }
}
