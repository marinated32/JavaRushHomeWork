package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader re = new BufferedReader ( new InputStreamReader (System.in) );
        String fullName = re.readLine ();
//        String fullName = "D:/marina/rush/someText.txt";
        ArrayList<Integer> list = new ArrayList<> (  );
        ArrayList<Integer> intList = new ArrayList<> (  );


        re.close ();

        FileInputStream inStream = new FileInputStream (fullName);
        Scanner scanner = new Scanner(inStream);

        while (scanner.hasNext()) {
            list.add ( scanner.nextInt () );
        }
        inStream.close ();
        scanner.close ();

        Collections.sort ( list );

        for (Integer i: list) {
            if (i %2 == 0)
                intList.add ( i );
        }

        for (Integer i: intList)
            System.out.println ( i );
    }
}
