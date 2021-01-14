package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
    }

    static {
        threads.add(new Thread(new Tr1()));
        threads.add(new Thread(new Th2()));
        threads.add(new Thread(new Th3()));
        threads.add(new Th4());
        threads.add(new Thread(new Th5()));
    }

    public static class Tr1  implements Runnable {
        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class Th2 implements Runnable  {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
//                    e.printStackTrace ();
                    // return;
                }
//                 if (isInterrupted()){
//                     System.out.println("InterruptedException");
//                     return;
//                 }
            }
        }
    }

    public static class Th3  implements Runnable {
        @Override
        public void run() {
            // try {
            //     while(true) {
            //         System.out.println ("Ура");
            //         Thread.sleep(500);
            //     }
            // }catch (InterruptedException e) {
            //         e.printStackTrace ();
            //         // return;
            // }
            
            
            while (true) {
                System.out.println ("Ура");
                try {
                    Thread.sleep ( 500 );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                    // break ;
                }
            }
        }
    }

    public static class Th4 extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt ();
        }

        @Override
        public void run() {
            while(!isInterrupted()){}
        }
    }

    public static class Th5 implements Runnable {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in) );
            int sum = 0;
            try {
                while (true) {
                    String line = reader.readLine();
                    if (line.equals("N")) break;
                    sum += Integer.parseInt(line);
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}