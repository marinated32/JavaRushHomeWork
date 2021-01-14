package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    static {
        try {
            readKeyFromConsoleAndInitPlanet ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String line = reader.readLine ();
        reader.close ();

        if (line.equals ( "sun" )) {
            thePlanet = Sun.getInstance ();
        }else if (line.equals ( "moon" )) {
            thePlanet = Moon.getInstance ();
        }else if (line.equals ( "earth" )) {
            thePlanet = Earth.getInstance ();
        }else {
            thePlanet = null;
        }
    }
}
