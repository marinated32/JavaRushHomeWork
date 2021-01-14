package com.javarush.task.task18.task1826;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream ( args[1] );
        FileOutputStream outputStream = new FileOutputStream ( args[2] );

        if (args[0].equals ( "-e" )) {
            while (inputStream.available () > 0 ) {
                int data = inputStream.read ()+1;
                outputStream.write ( data );
            }
        }else if (args[0].equals ( "-d" )) {
            while (inputStream.available () > 0 ) {
                int data = inputStream.read ()-1;
                outputStream.write ( data );
            }
        }
        inputStream.close ();
        outputStream.close ();
    }
}
