package com.javarush.task.task31.task3113;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static AtomicInteger fileCount = new AtomicInteger ( 0 );
    public static AtomicInteger dirCount = new AtomicInteger ( -1 );
    public static AtomicLong overallSize = new AtomicLong ( 0L );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        Path directory = Paths.get (reader.readLine ());
        reader.close ();

        if (!(Files.isDirectory ( directory ))) {
            System.out.println (directory.toString () + " - не папка");
            return;
        }

        Files.walkFileTree ( directory, new SimpleFileVisitor<Path> () {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (Files.isDirectory ( dir )) {
                    dirCount.incrementAndGet ();
                }
                return super.preVisitDirectory ( dir, attrs );
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isRegularFile ( file )) {
                    fileCount.incrementAndGet ();
                    overallSize.addAndGet ( Files.size ( file ) );
                }
                return super.visitFile ( file, attrs );
            }
        } );

        System.out.println ("Всего папок - " + dirCount.intValue ());
        System.out.println ("Всего файлов - " + fileCount.intValue ());
        System.out.println ("Общий размер - " + overallSize.intValue ());
    }
}
