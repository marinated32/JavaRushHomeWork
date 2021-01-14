package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

        while (true) {
            String line = reader.readLine ();
            if (line.equals ( "exit" ))
                break;
            new ReadThread (line).start ();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            super();
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            FileInputStream inputStream = null;
            List<Byte> byteList = new ArrayList<> (  );
            List<Integer> valueList = new ArrayList<> (  );
            int value = 0;



            try {
                inputStream = new FileInputStream ( fileName );
                byte[] buffer = new byte[inputStream.available ()];
                while (inputStream.available () > 0) {
                    inputStream.read (buffer);
                }

                for (byte b: buffer) {
                    if (!byteList.contains ( b )) {
                        byteList.add ( b );
                        for (byte but: buffer) {
                            if (but == b) {
                                value++;
                            }
                        }
                        valueList.add ( value );
                        value = 0;
                    }
                }

                resultMap.put ( fileName, (int) byteList.get ( valueList.indexOf ( Collections.max ( valueList ) ) ) );
                inputStream.close ();

            } catch (FileNotFoundException e) {
                e.printStackTrace ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }
}
//D:/test.txt
//D:/result.txt
