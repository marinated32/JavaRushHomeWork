package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("a");
        words.add("b");
        words.add("c");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String file = reader.readLine ();
        reader.close ();

        FileReader fileReader = new FileReader ( file );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );

        int sum = 0;

        while (bufferedReader.ready ()) {
            String line = bufferedReader.readLine ();
            String[] res = line.split ( " " );
            for (String str: res) {
                if (words.contains ( str )) {
                    sum++;
                }
            }

            if (sum == 2) {
                System.out.println (line);
            }
            sum = 0;
        }
        fileReader.close ();
    }
}
