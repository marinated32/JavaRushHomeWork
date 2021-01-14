package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileName = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( fileName );
        Scanner scanner = new Scanner ( inputStream );

        while (scanner.hasNextLine ()) {
            String line = scanner.nextLine ();
            if (line.startsWith ( args[0] + " ")) {
                System.out.println (line);
            }
        }
        inputStream.close ();
    }
}
//D:/test.txt
