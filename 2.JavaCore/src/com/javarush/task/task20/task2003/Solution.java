package com.javarush.task.task20.task2003;

import java.io.*;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
//        PrintWriter writer = new PrintWriter ( outputStream );
        Properties properties = new Properties (  );
        properties.putAll ( runtimeStorage );
        properties.store ( outputStream, "hey" );
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties (  );
        properties.load ( inputStream );
        for (String key : properties.stringPropertyNames()) {
            runtimeStorage.put ( key, properties.getProperty ( key ) );
        }
        inputStream.close ();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
    }
}
//D:/test.properties