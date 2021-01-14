package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileNameOne = br.readLine ();
        String fileNameTwo = br.readLine ();
        br.close ();

        BufferedReader reader = new BufferedReader ( new FileReader ( fileNameOne ) );
        BufferedWriter writer = new BufferedWriter ( new FileWriter ( fileNameTwo ) );

        List<Integer> list = new ArrayList<> (  );
        list.add ( 10 );
        list.add ( 123 );
        list.add ( 124 );
        list.add ( 125 );
        list.add ( 126 );
        for (int i = 33; i < 48; i++) {
            list.add ( i );
        }
        for (int i = 58; i < 65; i++) {
            list.add ( i );
        }
        for (int i = 91; i < 97; i++) {
            list.add ( i );
        }

        while (reader.ready ()) {
            int data = reader.read();
            if (!list.contains ( data )) {
                writer.write ( data );
            }
        }
        reader.close ();
        writer.close ();
    }
}
//D:/test.txt
//D:/result.txt