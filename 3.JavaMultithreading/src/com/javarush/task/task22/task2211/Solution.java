package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        InputStream inputStream = new FileInputStream (args[0]);
        OutputStream outputStream = new FileOutputStream ( args[1] );

        byte[] buffer = new byte[1000];
        inputStream.read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);
        outputStream.write(buffer);

        inputStream.close ();
        outputStream.close ();
    }
}
