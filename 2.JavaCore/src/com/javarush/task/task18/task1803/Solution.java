package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in) );
        String line = reader.readLine ();
        reader.close ();

        FileInputStream inputStream = new FileInputStream ( line );
        Map<Byte, Integer> map = new HashMap<> (  );

        while (inputStream.available () > 0) {
            int data = inputStream.read ();
            if (map.containsKey ( (byte) data )) {
                map.put((byte) data, map.get((byte) data)+1);
            }else {
                map.put ( (byte) data, 1 );
            }
        }
        inputStream.close ();

        int minByte = Integer.MIN_VALUE;

        for (Map.Entry<Byte, Integer> pair: map.entrySet ()) {
            if (pair.getValue () > minByte) {
                minByte = pair.getValue ();
            }
        }

        for (Map.Entry<Byte, Integer> pair: map.entrySet ()) {
            if (pair.getValue () == minByte) {
                System.out.print (pair.getKey () + " ");
            }
        }
    }
}
