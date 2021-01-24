package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.Buffer;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) {
            return new String (  );
        }
        StringWriter sw = new StringWriter (  );
        BufferedReader bf = new BufferedReader ( reader );
        String line;
        while ((line = bf.readLine ()) != null) {
            sw.write ( line );
        }
        char[] sequence = sw.toString ().toCharArray ();
//        System.out.println (sequence.length);
        for (int i = 0; i < sequence.length; i++) {
//            System.out.println (sequence[i]);
            sequence[i] = (char) (sequence[i] + key);
//            System.out.println (sequence[i]);
        }
//        System.out.println (String.valueOf ( sequence) );
        return String.valueOf ( sequence);
    }
}
