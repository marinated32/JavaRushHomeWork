package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile = args[0];
        String secondFile = args[1];
        String result = "";

        FileWriter writer = new FileWriter ( secondFile );
        FileReader fileReader = new FileReader ( firstFile );
        BufferedReader reader = new BufferedReader ( fileReader );

        while (reader.ready ()) {
            String line = reader.readLine ();

            for (String st: line.split ( " " )){
                if (st.length () > 6){
                    result += st + ",";
                }
            }
        }
        fileReader.close ();
        writer.write ( result.substring ( 0, result.length ()-1 ));
        writer.close ();
    }
}
//D:/test.txt D:/result.txt