package com.javarush.task.task19.task1923;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile = args[0];
        String secondFile = args[1];

        FileReader fileReader =  new FileReader ( firstFile );
        BufferedReader reader = new BufferedReader ( fileReader );

        FileWriter writer = new FileWriter ( secondFile );

        while (reader.ready ()) {
            String line = reader.readLine ();

            for (String st: line.split ( " " )) {
                if (st.matches ( ".*\\d.*" )) {
                    writer.write ( st + " " );
//                    System.out.println (st);
                }
            }
        }
        fileReader.close ();
        writer.close ();
    }
}
