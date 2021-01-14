package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream ( args[0] );
        int sum = 0;
//        int sumInt = 0;

        while (inputStream.available () > 0 ) {
            int in = inputStream.read ();
            if (in >= 65 && in <= 90 )
                sum++;
            if (in >= 97 && in <= 122)
                sum++;

//            if (in >= 48 && in <= 57 )
//                sumInt++;
        }
        inputStream.close ();
        System.out.println (sum);
    }
}
