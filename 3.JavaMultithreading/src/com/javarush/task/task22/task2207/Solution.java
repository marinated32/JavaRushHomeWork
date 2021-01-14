package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        FileReader file = new FileReader ( reader.readLine () );
        reader.close ();

        int data = file.read ();

        StringBuilder allInOne = new StringBuilder (  );

        while (data != -1) {
            allInOne.append ( (char) data );
            data = file.read ();
        }

        String[] mass = allInOne.toString ().replaceAll ( "\\R", " " ).split ( " " );

        for (int i = 0; i < mass.length; i++) {
            for (int j = 1; j < mass.length; j++) {
                if (i != j & mass[i] != null & mass[j] != null & (mass[i] != null && mass[i].equals ( mass[j] ) ) ) {
                    Pair name = new Pair ();
                    name.first = mass[i];
                    name.second = mass[j];
                    result.add ( name );
                    System.out.println ( name );
                    mass[i] = null;
                    mass[j] = null;
                }else if (i != j & mass[i] != null & mass[j] != null ) {
                    StringBuilder res = new StringBuilder ( mass[i] );
                    res.reverse ();
                    if (res.toString ().equals ( mass[j] )) {
                        Pair name = new Pair ();
                        name.first = mass[i];
                        name.second = mass[j];
                        result.add ( name );
                        System.out.println (name);
                        mass[i] = null;
                        mass[j] = null;
                    }
                }
            }
        }
//        for (Pair pair: result) {
//            System.out.println (pair.toString ());
//        }
    }
//    D:\test.txt

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}
