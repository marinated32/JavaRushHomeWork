package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String lineOne = reader.readLine ();
        String lineTwo = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( lineOne );
        FileOutputStream outputStream = new FileOutputStream ( lineTwo);
        byte[] byteMass = new byte[inputStream.available ()];

        try {
            if (inputStream.available () > 0) {
                inputStream.read (byteMass);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
        inputStream.close ();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write ( byteMass );
        String allLine = baos.toString ();

        List<Float> list = new ArrayList<> (  );
        List<Integer> listInt = new ArrayList<> (  );

        for (String str: allLine.split ( " " ))
            list.add ( Float.parseFloat ( str ) );

        for (Float num: list)
            listInt.add ( Math.round ( num ) );

        String result = "";

        for (Integer num: listInt)
            result += num + " ";

        outputStream.write ( result.getBytes () );
        outputStream.close ();
    }
}
//D:/test.txt
//D:/result.txt