package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = reader.readLine ();
        reader.close ();

        List<Byte> list = new ArrayList<> (  );

        FileInputStream inputStream = new FileInputStream ( line );
        while (inputStream.available () > 0) {
            int data = inputStream.read ();
            if (!list.contains ( (byte) data ))
                list.add ( (byte) data );
        }
        inputStream.close ();

        Collections.sort ( list );

        for (Byte by: list)
            System.out.print (by + " ");
    }
}
