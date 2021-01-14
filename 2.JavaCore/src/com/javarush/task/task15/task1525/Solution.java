package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            Scanner in = new Scanner (new File(Statics.FILE_NAME));
            while (in.hasNextLine())
                lines.add(in.nextLine());
        }catch(IOException e){
        }
    }



    public static void main(String[] args) {
        System.out.println(lines);
    }
}
