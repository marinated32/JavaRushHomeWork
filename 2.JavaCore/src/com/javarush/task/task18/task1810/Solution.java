package com.javarush.task.task18.task1810;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line;
        FileInputStream inputStream;

        while (true) {
            line = reader.readLine ();
            inputStream = new FileInputStream ( line );
            if (inputStream.available () < 1000) {
                reader.close ();
                inputStream.close ();
                throw new DownloadException ();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
