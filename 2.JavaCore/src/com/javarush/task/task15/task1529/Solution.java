package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        try {
            reset ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = reader.readLine ();
        int people;

        if (line.equals ( "helicopter" ))
            result = new Helicopter ();
        else if (line.equals ( "plane" )) {
            people = Integer.parseInt ( reader.readLine () );
            result = new Plane ( people );
        }

        reader.close ();
    }
}
