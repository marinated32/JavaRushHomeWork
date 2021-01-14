package com.javarush.task.task19.task1907;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ));
        String fileName = br.readLine ();
        br.close ();

        FileReader reader = new FileReader ( fileName );
        char[] byffer = new char[1000000];

        while (reader.ready ())
            reader.read(byffer);
        reader.close ();

        String res = String.valueOf ( byffer );
        String[] strArray = res.split(
                "[^a-zA-Z0-9]"
                //  "[\\s\\p{P}]"
                //  "\\p{Punct}"
        );

        int sum = 0;

        for (String str: strArray) {
            if (str.equals ( "world" )) {
                sum++;
            }
        }
        System.out.println (sum);
    }
}
//D:/test.txt
//D:/result.txt