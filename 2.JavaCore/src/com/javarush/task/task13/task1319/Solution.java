package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader re = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileName = re.readLine ();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        while (true) {
            String line = re.readLine ();
            if (line.equals ( "exit" )) {
                writer.write(line + "\r\n");
                break;
            } else {
                writer.write(line+ "\r\n");
            }
        }

        re.close ();
        writer.close ();
    }
}
//D:/marina/rush/someText.txt
//Hello  World!\nHey! Teachers! Leave them kids alone.  "\r\n"