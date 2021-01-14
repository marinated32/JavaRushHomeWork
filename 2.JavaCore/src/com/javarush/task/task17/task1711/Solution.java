package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createFemale ( "Marina", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    createPeople ( args );
                }
                break;
            case "-u" :
                synchronized (allPeople) {
                    updatePeople ( args );
                }
                break;
            case "-d" :
                synchronized (allPeople) {
                    deleteId ( args );
                }
                break;
            case "-i" :
                synchronized (allPeople) {
                    infoId ( args );
                }
                break;
        }
    }

    public static void createPeople(String[] args) throws ParseException {
        Date bd;

        for (int i = 1; i<args.length; i+=3) {
            bd = new SimpleDateFormat ( "dd/MM/yyyy", Locale.ENGLISH ).parse ( args[i+2] );

            if (args[i+1].equals ( "м" )) {
                allPeople.add ( Person.createMale ( args[i], bd ) );
            } else if (args[i+1].equals ( "ж" )) {
                allPeople.add ( Person.createFemale ( args[i], bd ) );
            }
            System.out.println (allPeople.size () - 1);
        }
    }

    public static void updatePeople(String[] args) throws ParseException {
        Sex sex = null;
        Date bd;

        for (int i=1; i<args.length; i+=4) {
            if (args[i+2].equals ( "м" )) { sex = Sex.MALE;
            }else if (args[i+2].equals ( "ж" )) { sex = Sex.FEMALE; }

            bd = new SimpleDateFormat ( "dd/MM/yyyy", Locale.ENGLISH ).parse ( args[i+3] );

            allPeople.get(Integer.parseInt ( args[i])).setName (args[i+1]);
            allPeople.get(Integer.parseInt ( args[i])).setBirthDate (bd);
            allPeople.get(Integer.parseInt ( args[i])).setSex ( sex );
        }
    }

    public static void deleteId(String[] args) {
        for (int id = 1; id < args.length; id++) {
            allPeople.get(Integer.parseInt ( args[id])).setName (null);
            allPeople.get(Integer.parseInt ( args[id])).setBirthDate (null);
            allPeople.get(Integer.parseInt ( args[id])).setSex (null);
        }
    }

    public static void infoId(String[] args) {
        String stringDate;

        for (int id=1; id<args.length; id++) {
            System.out.print ( allPeople.get ( Integer.parseInt ( args[id] ) ).getName () + " " );

            if (Sex.MALE.equals ( allPeople.get ( Integer.parseInt ( args[id] )).getSex () )) {
                System.out.print ( "м" + " " );
            } else if (Sex.FEMALE.equals ( allPeople.get ( Integer.parseInt ( args[id]) ).getSex () )) {
                System.out.print ( "ж" + " " );
            }

            stringDate = new SimpleDateFormat ( "dd-MMM-yyyy", Locale.ENGLISH ).format ( allPeople.get ( Integer.parseInt ( args[id]) ).getBirthDate () );
            System.out.println ( stringDate );
        }
    }
}
