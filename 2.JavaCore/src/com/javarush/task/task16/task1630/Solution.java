package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        try {
            firstFileName = reader.readLine ();
            secondFileName = reader.readLine ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        try {
            reader.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join ();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileName;
        private String result = "";
        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return result;
        }

        @Override
        public void run() {
            Path path = Paths.get ( fileName );
            Scanner scanner = null;

            try {
                scanner = new Scanner ( path );
            } catch (IOException e) {
                e.printStackTrace ();
            }

            while (scanner.hasNext ()){
                result += scanner.nextLine () + " ";
            }
            scanner.close ();
        }
    }
}
