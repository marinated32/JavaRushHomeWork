package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try{
            String template = "Some text for ";
            for (int i = 1; i < 10000; i++) {
                map.put ( String.valueOf ( i ), template + i );
                Thread.sleep ( 500 );
            }
        } catch (Exception e) {
            System.out.println ("[" + Thread.currentThread ().getName () + "] thread was terminated");
        }
    }
}
