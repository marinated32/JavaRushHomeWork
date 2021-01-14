package com.javarush.task.task25.task2505;

/* 
Без дураков
*/

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep ( 500 );
                    System.out.println (String.format ( "%s, %s, %s", secretKey,
                            t.getName (), e.getLocalizedMessage () ));
                } catch (InterruptedException ex) {
                    ex.printStackTrace ();
                }

            }
        }


        public MyThread(String secretKey) {
            this.secretKey = secretKey;
//            System.out.println ("hi1");
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            System.out.println ("hi2");
//            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

