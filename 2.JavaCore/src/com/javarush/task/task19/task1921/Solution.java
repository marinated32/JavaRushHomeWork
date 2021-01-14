package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String file = args[0];

        FileReader fileReader = new FileReader ( file );
        BufferedReader reader = new BufferedReader ( fileReader );

        while (reader.ready ()) {
            String line = reader.readLine ();
            String[] res = line.split ( "(?=\\d)", 2 );
            String name = res[0].substring ( 0, res[0].length ()-1 );
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "dd MM yyyy" );
            Date date = simpleDateFormat.parse ( res[1] );

            PEOPLE.add (new Person ( name, date ) );
        }
        fileReader.close ();
    }
}
//D:/test.txt