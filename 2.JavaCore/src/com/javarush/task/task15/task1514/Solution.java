package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static {
        labels.put ( 34.98, "sldfj" );
        labels.put ( 34.5598, "fguk" );
        labels.put ( 34564.98, "dfgg" );
        labels.put ( 34.98698, "erwr" );
        labels.put ( 34756.98, "sloil;iodfj" );
    }
}
