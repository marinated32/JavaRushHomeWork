package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<> (  );
        File rootFolder = new File ( root );

        Files.walkFileTree ( rootFolder.toPath (), new SimpleFileVisitor<Path> () {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                result.add (file.toFile ().getAbsolutePath ());
                return FileVisitResult.CONTINUE;
            }
        } );

        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println (getFileTree ( "D:\\" ));
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
