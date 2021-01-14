package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler () {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
//                int nameLength = t.getName ().length ();
//                String newName = "";
//                for (int i = 0; i < nameLength; i++) {
//                    newName += "*";
//                }
//                System.out.println (e.getMessage ());
//                String[] message = e.getMessage ().split ( " " );
//                for (int i = 0; i < message.length; i++) {
//                    if (t.getName ().equals ( message[i] )) {
//                        message[i] = newName;
//                    }
//                }
//                for (String st: message)
//                    System.out.print (st + " ");
                System.out.println (e.getMessage ().replaceAll ( t.getName (), t.getName ().replaceAll ( ".","*" ) ));
            }
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException();
            }
        }).run();
    }
}
