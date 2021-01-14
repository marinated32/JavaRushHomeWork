package com.javarush.task.task19.task1918;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileName = reader.readLine ();
        reader.close ();

        String teg = args[0];

        FileReader fileReader = new FileReader ( fileName );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );

        List<String> list = new ArrayList<>();
        List<Integer> stList = new ArrayList<>();
        List<Integer> finList = new ArrayList<>();

        while (bufferedReader.ready ()) {
            list.add( bufferedReader.readLine () );
        }
        fileReader.close ();

        String res = "";
        for (String st: list) {
            res += st +" ";
        }

        Pattern start = Pattern.compile ( "<" + teg );
        Pattern finish = Pattern.compile ( "</" + teg + ">" );

        Matcher stmatcher = start.matcher ( res );
        Matcher finmatcher = finish.matcher ( res );

        while (stmatcher.find ()) {
            stList.add ( stmatcher.start () );
//            System.out.println (res.substring ( stmatcher.start () ));
        }
        while (finmatcher.find ()) {
            finList.add ( finmatcher.end () );
        }

//        System.out.println (stList);
//        System.out.println (res.substring ( stList.get ( 2 ), finList.get ( 2 ) ));
//        System.out.println (finList);

        for (int i = 0; i < stList.size(); i++) {
            for (int j = i + 1; j < stList.size(); j++) {
                if (stList.get(j) < finList.get(i)) {
                    int temp = finList.get(j);
                    finList.set(j, finList.get(i));
                    finList.set(i, temp);
                } else {
                    break;
                }
            }
        }

//        System.out.println (stList);
//        System.out.println (finList);
        for (int i = 0; i < stList.size (); i++) {
            System.out.println (res.substring ( stList.get ( i ), finList.get ( i )));
        }

    }
}
//D:/test.txt