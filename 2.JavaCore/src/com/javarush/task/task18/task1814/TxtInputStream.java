package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TxtInputStream extends FileInputStream {
//    String fileName;
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException, IOException {
        super(fileName);
        if(!fileName.endsWith(".txt"))
        {
            super.close();
            throw new UnsupportedFileNameException();

        }
        else
            new FileInputStream(fileName);
    }

    public static void main(String[] args) {
    }
}

