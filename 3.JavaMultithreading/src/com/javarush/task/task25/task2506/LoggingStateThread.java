package com.javarush.task.task25.task2506;


public class LoggingStateThread extends Thread {
    private Thread thread;

    @Override
    public void run() {
        super.run ();
        State current = thread.getState ();
        System.out.println (current);
        while (true) {
            if (!(current.equals ( thread.getState () ))) {
                System.out.println ( thread.getState () );
                current = thread.getState ();
            }
            if (current.equals ( State.TERMINATED ))
                break;
        }
    }

    public LoggingStateThread(Thread thread) {
//        System.out.println(thread.getState());
        this.thread = thread;
        this.setDaemon ( true );
    }
}