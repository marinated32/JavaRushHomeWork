package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        Map<Integer, byte[]> map = new HashMap<> (  );
        List<String> list = new ArrayList<> (  );

        while (true) {
            String line = reader.readLine ();
            if (line.equals ( "end" ))
                break;
            list.add ( line );
        }
        try {
            for (String line:list) {
                int indexNum = line.lastIndexOf ( "t" );
                int num = Integer.parseInt ( line.substring ( indexNum + 1 ) );

                FileInputStream inputStream = new FileInputStream ( line );
                byte[] buffer = new byte[inputStream.available ()];
                if (inputStream.available () > 0) {
                    inputStream.read ( buffer );
                }
                map.put ( num, buffer );
                inputStream.close ();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        String resultFile = list.get ( 1 ).substring ( 0, list.get(1).lastIndexOf ( "." ) );
        FileOutputStream outputStream = new FileOutputStream ( resultFile , true);

        for (int i = 1; i <= map.size (); i++) {
            outputStream.write ( map.get(i) );
        }
        outputStream.close ();
    }
}
//D:/test.txt.part1
//D:/test.txt.part2
