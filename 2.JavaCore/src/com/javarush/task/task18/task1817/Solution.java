package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream ( args[0] );
        int space = 0;
        int all = 0;
        double result = 0d;

        while (inputStream.available () > 0 ) {
            int data = inputStream.read ();
            if (data == 32) {
                space++;
                all++;
            }else { all++;}
        }
        inputStream.close ();

        result = (double) space / all * 100;
        System.out.printf ("%.2f", result);
    }
}
