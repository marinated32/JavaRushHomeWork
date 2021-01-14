package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e == null) return;
            t.interrupt ();
            uncaughtException ( t, e.getCause () );
            System.out.println ( e.getClass ().getName () + ": " + e.getLocalizedMessage () );


    }

    public static void main(String[] args) throws Exception {
        new Solution().uncaughtException(new Thread(), new Exception("ABC",
                new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
