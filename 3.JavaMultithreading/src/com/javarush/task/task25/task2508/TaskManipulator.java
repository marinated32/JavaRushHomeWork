package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
//    public String threadName;
    public Thread thread;
    
    @Override
    public void run() {
        while(!thread.isInterrupted()) {

            try {
                System.out.println(Thread.currentThread ().getName ());
                Thread.sleep(100);
            }catch (InterruptedException e) {
//                e.printStackTrace();
                break;
            }
        }
    }
    
    public void start(String threadName) {
//        this.threadName = threadName;
        thread = new Thread(this, threadName);
//        thread.setName ( threadName );
        thread.start ();
    }

    public void stop() {
        thread.interrupt ();
    }
}
