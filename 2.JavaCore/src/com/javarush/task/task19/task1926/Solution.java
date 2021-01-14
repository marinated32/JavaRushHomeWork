package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String file = reader.readLine ();
        reader.close ();

        FileReader fileReader = new FileReader ( file );
        BufferedReader buffer = new BufferedReader ( fileReader );

        while (buffer.ready ()) {
            String ster = buffer.readLine ();
            StringBuilder stringBuilder = new StringBuilder ( ster );
            stringBuilder.reverse ();
            System.out.println ( stringBuilder.toString () );
        }
        fileReader.close ();
    }
}
//D:/test.txt