package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException, NullPointerException {
        // напишите тут ваш код
        BufferedReader re = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = "";
        InputStream  inputFile = null;
//        D:/marina/rush/hgjf;.txt
        try {
            line = re.readLine ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        re.close ();
        try {
            inputFile = new FileInputStream ( line );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }


        while (inputFile.available() > 0) {
            int data = inputFile.read(); //читаем один int из потока для чтения
            System.out.print ( (char) data );
        }


        inputFile.close ();


    }
}