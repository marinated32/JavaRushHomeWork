package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", "."));
    }

    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> tokens = new ArrayList<> ();
        StringTokenizer strT = new StringTokenizer(query,delimiter);
        while (strT.hasMoreTokens()){
            tokens.add(strT.nextToken());
        }
        return tokens.toArray(new String[0]);
    }
}
