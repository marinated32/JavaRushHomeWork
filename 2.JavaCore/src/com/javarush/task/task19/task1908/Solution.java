package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter( new FileWriter(reader.readLine()));
        reader.close();
        ArrayList<String> listOfLines = new ArrayList<>();

        while (fileReader.ready()) {
            listOfLines.add(fileReader.readLine());
        }
        for(String line : listOfLines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (isNumeric(word)) fileWriter.write(word + " ");
            }
        }
        fileWriter.close();
        fileReader.close();
    }

    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
//D:/test.txt
//D:/result.txt