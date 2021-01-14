package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String lineOne = reader.readLine ();
        String lineTwo = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( lineOne );
        FileOutputStream outputStream = new FileOutputStream ( lineTwo );

        byte[] mass = new byte[inputStream.available ()];
        if (inputStream.available () > 0) {
            inputStream.read (mass);
        }
        for (int i = mass.length-1; i >=0; i--) {
            outputStream.write ( mass[i] );
        }
        inputStream.close ();
        outputStream.close ();
    }
}

//D:/test.txt
//D:/result.txt
