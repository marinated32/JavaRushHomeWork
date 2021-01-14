package com.javarush.task.task17.task1721;

import javafx.scene.shape.Path;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String lineOne = "", lineTwo = "";

        try {
            lineOne = reader.readLine ();
            lineTwo = reader.readLine ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        reader.close ();

        File fileOne = new File (lineOne);
        File fileTwo = new File (lineTwo);

        Scanner scanner = new Scanner ( fileOne );
        while (scanner.hasNext ()) {
            allLines.add ( scanner.nextLine () );
        }
        scanner.close ();

        Scanner scanner2 = new Scanner ( fileTwo );
        while (scanner2.hasNext ()) {
            forRemoveLines.add ( scanner2.nextLine () );
        }
        scanner2.close ();

        new Solution ().joinData();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll ( forRemoveLines )) {
            allLines.removeAll ( forRemoveLines );
        }else {
            allLines.clear ();
            throw new CorruptedDataException ();
        }
    }
}
//D:/marina/rush/someText.txt
//D:/marina/rush/someText2.txt