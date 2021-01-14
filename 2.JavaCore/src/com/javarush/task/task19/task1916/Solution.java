package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String firstFile = reader.readLine ();
        String secondFile = reader.readLine ();
        reader.close ();

        List<String> firstList = new ArrayList<> (  );
        List<String> secondList = new ArrayList<> (  );

        FileReader firstReader = new FileReader ( firstFile );
        BufferedReader freader = new BufferedReader ( firstReader );
        FileReader secondReader = new FileReader ( secondFile );
        BufferedReader sereader = new BufferedReader ( secondReader );

        while (freader.ready ()) {
            firstList.add ( freader.readLine () );
        }
        freader.close ();
        while (sereader.ready ()) {
            secondList.add ( sereader.readLine () );
        }
        sereader.close ();

        int j = 0, i = 0;
        while (i < firstList.size() || j < secondList.size()) {

            if (i == firstList.size()) {
                lines.add(new LineItem(Type.ADDED, secondList.get(j)));
                break;
            }
            if (j == secondList.size()) {
                lines.add(new LineItem(Type.REMOVED, firstList.get(i)));
                break;
            }

            if (firstList.get ( i ).equals ( secondList.get ( j ) )) {
                lines.add ( new LineItem ( Type.SAME, firstList.get ( i ) ) );
                j++;
                i++;
            } else if (firstList.get ( i ).equals ( secondList.get ( j + 1 ) )) {
                lines.add ( new LineItem ( Type.ADDED, secondList.get ( j ) ) );
                j++;
            } else if (firstList.get ( i + 1 ).equals ( secondList.get ( j ) )) {
                lines.add ( new LineItem ( Type.REMOVED, firstList.get ( i ) ) );
                i++;
            }

        }

//        for (LineItem line: lines) {
//            System.out.println (line.type + " " + line.line);
//        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
//D:/test.txt
//D:/result.txt
