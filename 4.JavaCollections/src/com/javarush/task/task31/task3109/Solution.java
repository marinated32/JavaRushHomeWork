package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties result = new Properties (  );

        try {
            if (fileName.endsWith ( ".xml" )) {
                result.loadFromXML ( new FileInputStream ( fileName ) );
            } else if (Files.isRegularFile ( Paths.get ( fileName ) )) {
                result.load ( new FileReader ( new File ( fileName ) ) );
            }
        }catch (IOException e) {
            return result;
        }
        return result;
    }
}
