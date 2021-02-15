package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream ( args[0] );
        StringBuilder builder = new StringBuilder (  );
        int i = -1;
        
        while (( i= fileInputStream.read ()) != -1) {
            builder.append ( (char) i );
        }
        fileInputStream.close ();
        
        String res = builder.toString ().toLowerCase ();
        char[] chars = res.toCharArray ();
        Set<Character> tree = new TreeSet<> (  );

        for (char ch: chars) {
            if (ch >= 97 && ch <=122) {
                if (!tree.contains ( ch )) {
                    tree.add ( ch );
                }
            }
        }

        StringBuilder result = new StringBuilder (  );
        for (Character ch: tree) {
            result.append ( ch );
        }

        if (result.toString ().length () <= 5) {
            System.out.print ( result.toString () );
        } else {
            System.out.println (result.toString ().substring ( 0, 5 ));
        }
    }
}
