package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        InputStream reader = new FileInputStream ( new File ( fileName ) );
        ObjectMapper mapper = new ObjectMapper (  );
        Object obj = mapper.readValue ( reader, clazz );
        reader.close ();
        return (T) obj;
    }

    public static void main(String[] args) {

    }
}
