package com.javarush.task.task18.task1818;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String lineOne = reader.readLine ();
        String lineTwo = reader.readLine ();
        String lineThree = reader.readLine ();
        reader.close ();

        FileOutputStream outputStream = new FileOutputStream ( lineOne, true );
        FileInputStream inputStreamTwo = new FileInputStream ( lineTwo );
        FileInputStream inputStreamThree = new FileInputStream ( lineThree );

        while (inputStreamTwo.available () > 0 ) {
            outputStream.write ( inputStreamTwo.read () );
        }

        while (inputStreamThree.available () > 0 ) {
            outputStream.write ( inputStreamThree.read () );
        }
        inputStreamThree.close ();
        inputStreamTwo.close ();
        outputStream.close ();
    }
}
