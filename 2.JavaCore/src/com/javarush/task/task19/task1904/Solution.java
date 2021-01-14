package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter  implements PersonScanner{
        private final Scanner fileScanner;


        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String temp = fileScanner.nextLine();
            String[] subStr = temp.split(" ", 4);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("dd MM yyyy").parse(subStr[3]);
            } catch (ParseException e) {
                System.err.println("Строка не распаршена!");
            }
            Person person = new Person(subStr[1], subStr[2], subStr[0], birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close ();
        }
    }
}
