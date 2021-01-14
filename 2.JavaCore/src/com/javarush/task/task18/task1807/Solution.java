package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( line );
        byte intByte = 44;
        int sum = 0;

        while (inputStream.available () > 0) {
            if (inputStream.read () == intByte) {
                sum++;
            }
        }
        inputStream.close ();
        System.out.println (sum);
    }
}
