package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get ( args[0] );
        File resultFileAbsolutePath = new File ( args[1] );
        File renamedSource = new File ( resultFileAbsolutePath.getParent () + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, renamedSource);
        List<File> res = new ArrayList<> (  );

        Files.walkFileTree ( path, new SimpleFileVisitor<Path> (){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toFile ().length () <= 50) {
                    res.add ( file.toFile () );
                }
                return FileVisitResult.CONTINUE;
            }
        });

        Collections.sort ( res, new Comparator<File> () {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName ().compareTo ( o2.getName () );
            }
        } );

        try (BufferedWriter fWrite = new BufferedWriter ( new FileWriter ( renamedSource ))) {
            for (File file: res) {
                BufferedReader reader = new BufferedReader ( new FileReader ( file ) );
                while (reader.ready ()) {
                    fWrite.write ( reader.read () );
                }
                fWrite.write ( "\n");
                reader.close ();
            }
        }

    }
}
