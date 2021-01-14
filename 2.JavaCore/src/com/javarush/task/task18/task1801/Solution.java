package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = reader.readLine ();
        reader.close ();

        int maxByte = Integer.MIN_VALUE;
        FileInputStream inputStream = new FileInputStream(line);
        while (inputStream.available () > 0) {
            int current = inputStream.read () ;
            if (current > maxByte)
                maxByte = current;
        }
        inputStream.close ();

        System.out.println (maxByte);
    }
}
