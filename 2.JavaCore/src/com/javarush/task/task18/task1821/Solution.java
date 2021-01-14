package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream ( args[0] );
        byte[] buffer = new byte[inputStream.available ()];
        Map<Byte, Character> byteCharMap = new TreeMap<> ();
        Map<Character, Integer> charIntMap = new HashMap<> (  );
        int cout = 0;

        if (inputStream.available () > 0) {
            inputStream.read (buffer);
        }
        inputStream.close ();

        for (byte byt: buffer) {
            if (!byteCharMap.containsKey ( byt )) {
                for (byte b: buffer) {
                    if (b == byt) {
                        cout++;
                    }
                }
                byteCharMap.put ( byt, (char) byt );
                charIntMap.put ( (char) byt, cout );
                cout = 0;
            }
        }

        for (Map.Entry<Byte, Character> pair: byteCharMap.entrySet ()) {
            System.out.println (pair.getValue () + " " + charIntMap.get(pair.getValue ()));
        }
    }
}
