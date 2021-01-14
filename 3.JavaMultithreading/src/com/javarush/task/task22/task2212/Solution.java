package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty ()) return false;

        int numDigit = 0;
        int openS = 0;
        int closeS = 0;
        for (char ch: telNumber.toCharArray ()) {
            if (Character.isLetter ( ch )) return false;
            if (Character.isDigit ( ch ) ) {
                numDigit++;
            }
            if (ch == '(')
                openS = telNumber.indexOf ( ch );
            if (ch == ')')
                closeS = telNumber.indexOf ( ch );
        }
        if (!(numDigit == 12 | numDigit == 10)) return false;
        if (openS > closeS) {
            return false;
        }
        else if (closeS > 0 && closeS > openS ) {
            Pattern tree = Pattern.compile ( "[\\d]{3}" );
            Matcher mTree = tree.matcher ( telNumber.substring ( openS, closeS + 1 ) );
            if (!mTree.find ()) return false;
        }

        Pattern justTire = Pattern.compile ( "\\+?\\d*(\\([\\d]{3}\\))?\\d+-?\\d{2}-?\\d{2}$");
        Matcher mJustTire = justTire.matcher ( telNumber );
        if (!mJustTire.find ()) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println ("1 + " + checkTelNumber ( "+380501234567p" ));
        System.out.println ("2 + " + checkTelNumber ( "++38(050)1234567" ));
        System.out.println ("3 + " + checkTelNumber ( "+38050123-45-67" ));
        System.out.println ("4 + " + checkTelNumber ( "050123-4567-" ));
        System.out.println ("5 + " + checkTelNumber ( "+38)050(1234567" ));
        System.out.println ("6 + " + checkTelNumber ( "+38(050)1-23-45-6-7" ));
        System.out.println ("7 + " + checkTelNumber ( ")050ххх4567" ));
        System.out.println ("8 + " + checkTelNumber ( "a/050123456" ));
        System.out.println ("9 + " + checkTelNumber ( "(0)501234567" ));
    }
}
