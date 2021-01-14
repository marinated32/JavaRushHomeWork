package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileNameOne = reader.readLine ();
        String fileNameTwo = reader.readLine ();
        reader.close ();

        int count = 1;

        FileReader reader1 = new FileReader ( fileNameOne );
        FileWriter writer = new FileWriter ( fileNameTwo );

        while (reader1.ready ()) {
            int data = reader1.read ();
            if (count % 2 == 0) {
                writer.write ( data );
            }
            count++;
        }
        reader1.close ();
        writer.close ();
    }
}
//D:/test.txt
//D:/result.txt
