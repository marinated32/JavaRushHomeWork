package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile ( args[0], "rw" );
        long number = Long.parseLong ( args[1] );
        String textIn = args[2];
        byte[] buffer = new byte[textIn.length ()];

        raf.seek ( number );
        raf.read ( buffer, 0, textIn.length () );
        raf.seek ( raf.length () );
        if (textIn.equals ( new String ( buffer ) )) {
            raf.write ( "true".getBytes () );
        } else {
            raf.write ( "false".getBytes () );
        }
        raf.close ();
    }
}
