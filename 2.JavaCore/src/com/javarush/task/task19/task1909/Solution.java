package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileNameOne = br.readLine ();
        String fileNameTwo = br.readLine ();
        br.close ();

        BufferedReader reader = new BufferedReader ( new FileReader ( fileNameOne ) );
        BufferedWriter writer = new BufferedWriter ( new FileWriter ( fileNameTwo ) );

        while (reader.ready ()) {
            int data = reader.read ();
            if (data == 46) {
                data = 33;
            }
            writer.write ( data );
        }
        reader.close ();
        writer.close ();
    }
}
//D:/test.txt
//D:/result.txt