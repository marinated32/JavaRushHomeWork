package com.javarush.task.task18.task1819;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String lineOne = reader.readLine ();
        String lineTwo = reader.readLine ();
        reader.close ();


        FileInputStream inputStreamOne = new FileInputStream ( lineOne );
        FileInputStream inputStreamTwo = new FileInputStream ( lineTwo );

        byte[] buffer = new byte[inputStreamOne.available ()];
//        byte[] buffer2 = new byte[inputStreamTwo.available ()];
//        int count = 0;
//        int sum = inputStreamOne.available () + inputStreamTwo.available ();

        while (inputStreamOne.available () > 0 ) {
            inputStreamOne.read ( buffer );
        }
//        while (inputStreamTwo.available () > 0 ) {
//            inputStreamTwo.read ( buffer2 );
//        }

        FileOutputStream outputStream = new FileOutputStream ( lineOne );
        while (inputStreamTwo.available () > 0 ) {
            outputStream.write ( inputStreamTwo.read () );
        }
        outputStream.write ( buffer );

        outputStream.close ();
        inputStreamOne.close ();
        inputStreamTwo.close ();
    }
}
//D:\test.txt
//D:\result.txt