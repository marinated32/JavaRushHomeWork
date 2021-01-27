package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is == null) {
            return new StringWriter (  );
        }
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( is ) );
        StringWriter result = new StringWriter ();

        String res = "";

        while (reader.ready ()) {
            res = reader.readLine ();
            result.write ( res );
        }

        reader.close ();
        return result;
    }
}