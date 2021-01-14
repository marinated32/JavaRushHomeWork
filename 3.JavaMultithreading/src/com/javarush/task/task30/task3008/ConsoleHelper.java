package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

    public static String readString() {
        String result = "";
        try {
            result = reader.readLine ();
        } catch (IOException e) {
            System.out.println ("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            result = readString ();
        }
        return result;
    }

    public static int readInt() {
        int result;
        try {
            result = Integer.parseInt ( readString () );
        } catch (NumberFormatException e) {
            System.out.println ("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            result = Integer.parseInt ( readString () );
        }
        return result;
    }

    public static void writeMessage(String message) {
        System.out.println (message);
    }
}
