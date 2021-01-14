package com.javarush.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    public static String amigo = "JavaRush © All rights reserved.";
//    byte[] str = amigo.getBytes ();
    public FileOutputStream original;

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {
        super ( String.valueOf ( file ) );
    }

    @Override
    public void flush() throws IOException {
        original.flush ();
    }

    @Override
    public void write(int b) throws IOException {
        original.write ( b );
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write ( b );
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write ( b, off, len );
    }

    @Override
    public void close() throws IOException {
        this.original.flush ();
        byte[] str = amigo.getBytes ();
        this.original.write ( str );
        this.original.close ();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
