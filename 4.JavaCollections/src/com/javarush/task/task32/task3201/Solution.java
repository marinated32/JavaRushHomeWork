package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile ( args[0], "rw" );
        long number = Long.parseLong ( args[1] );
        String text = args[2];

        if (raf.length () < number)
            raf.seek ( raf.length () );
        else raf.seek ( number );

        raf.write ( text.getBytes () );
        raf.close ();

    }
}
