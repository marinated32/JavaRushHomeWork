package com.javarush.task.task18.task1827;

import javax.swing.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        String fileName = reader.readLine ();
        reader.close ();

        if (args.length == 0)
            return;

        if (args[0].equals ( "-c" )) {

            String lastLine = "";
            List<Integer> maxId = new ArrayList<> (  );

            FileInputStream inputStream = new FileInputStream ( fileName );
            Scanner scanner = new Scanner ( inputStream );
            while (scanner.hasNextLine ()) {
                lastLine = scanner.nextLine ();
                maxId.add ( Integer.parseInt ( lastLine.substring ( 0, 8 ).trim ( ) ) );
            }
            inputStream.close ();

            int resultId = Collections.max ( maxId ) + 1;

            String result = String.format("\n%-8d%-30.30s%-8.8s%-4.4s", resultId, args[1], args[2], args[3]);

            FileOutputStream outputStream = new FileOutputStream ( fileName, true );
            outputStream.write ( result.getBytes () );
            outputStream.close ();
        }
    }
}
//D:/test.txt