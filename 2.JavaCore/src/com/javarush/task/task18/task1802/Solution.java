package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( line );
        int minByte = Integer.MAX_VALUE;
        while (inputStream.available () > 0) {
            int current = inputStream.read ();
            if (current < minByte)
                minByte = current;
        }
        inputStream.close ();

        System.out.println (minByte);
    }
}
