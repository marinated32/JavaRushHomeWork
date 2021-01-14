package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    // создаем 5 конструкторов как в классе FileWriter и инициализируем переменную нашего класса
    public FileConsoleWriter(String name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(String name, boolean bool) throws IOException {
        this.fileWriter = new FileWriter(name, bool);
    }
    public FileConsoleWriter(File name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(File name, boolean bool) throws IOException {
        this.fileWriter = new FileWriter(name, bool);
    }
    public FileConsoleWriter(FileDescriptor descriptor) throws IOException {
        this.fileWriter = new FileWriter(descriptor);
    }

    // в аналогичных методах расщиряем их функциональность выводом в консоль
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off+len));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off+len));
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }


    public static void main(String[] args) {}

}
