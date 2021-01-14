package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Date date;
        if (args[0].equals ( "-c" )) {
            date = new SimpleDateFormat ( "dd/MM/yyyy", Locale.ENGLISH ).parse ( args[3] );
            createPeople ( args[1], args[2], date );
        }else if (args[0].equals ( "-u" )) {
            updatePeople ( Integer.parseInt ( args[1]), args[2], args[3], args[4] );
        }else if (args[0].equals ( "-d" )) {
            deleteId ( Integer.parseInt ( args[1] ) );
        }else if (args[0].equals ( "-i" )) {
            infoId ( Integer.parseInt ( args[1] ) );
        }
    }

    public static void createPeople(String name, String sex, Date bd) {
        Person person = null;
        if (sex.equals ( "m" ) || sex.equals ( "м" )) {
            allPeople.add ( person.createMale ( name, bd ) );
        }else if (sex.equals ( "ж" )) {
            allPeople.add ( person.createFemale ( name, bd ) );
        }
//        if (person != null)
        System.out.println (allPeople.size () - 1);
    }

    public static void updatePeople(int id, String name, String sexString, String bdString) throws ParseException {
        Sex sex;
        Date bd;

        if (sexString.equals ( "m" ) || sexString.equals ( "м" )) {
            sex = Sex.MALE;
        }else {sex = Sex.FEMALE;}

        bd = new SimpleDateFormat ( "dd/MM/yyyy", Locale.ENGLISH ).parse ( bdString );

        allPeople.get(id).setName (name);
        allPeople.get(id).setBirthDate (bd);
        allPeople.get(id).setSex (sex);
    }

    public static void deleteId(int id) {
        allPeople.get(id).setName (null);
        allPeople.get(id).setBirthDate (null);
        allPeople.get(id).setSex (null);
    }

    public static void infoId(int id) {
        System.out.print (allPeople.get(id).getName () + " ");

        if (Sex.MALE.equals ( allPeople.get(id).getSex () )) {
            System.out.print ("м" + " ");
        }else {System.out.print ("ж" + " ");}

        String stringDate = new SimpleDateFormat ( "dd-MMM-yyyy", Locale.ENGLISH ).format ( allPeople.get(id).getBirthDate () );
        System.out.print ( stringDate);
    }
}
