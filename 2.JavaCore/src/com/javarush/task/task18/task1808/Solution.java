package com.javarush.task.task18.task1808;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String lineOne = reader.readLine ();
        String lineTwo = reader.readLine ();
        String lineTree = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( lineOne );
        FileOutputStream outputStream = new FileOutputStream ( lineTwo );
        FileOutputStream outputStream2 = new FileOutputStream ( lineTree );

        int midle = 0;

        if (inputStream.available () % 2 == 0) {
            midle = inputStream.available () / 2;
        }else { midle = inputStream.available () / 2 +1;
        }

        byte[] buffer = new byte[midle];
        if (inputStream.available () > 0) {
            int data = inputStream.read (buffer);
            outputStream.write ( buffer, 0, data );
        }
        outputStream.close ();

        byte[] buffer2 = new byte[inputStream.available ()];
        if (inputStream.available () > 0) {
            int data = inputStream.read (buffer2);
            outputStream2.write (  buffer2, 0, data );
        }
        inputStream.close ();
        outputStream2.close ();
    }
}
//D:/test.txt
//D:/result.txt
//D:/result2.txt
