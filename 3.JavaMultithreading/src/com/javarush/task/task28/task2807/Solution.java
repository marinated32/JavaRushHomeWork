package com.javarush.task.task28.task2807;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Знакомство с ThreadPoolExecutor
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Add your code here
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<> (  );
        AtomicInteger integer = new AtomicInteger ( 1 );
        for (int i = 1; i < 11; i++) {
            queue.add ( new Runnable () {
                @Override
                public void run() {
                    doExpensiveOperation ( integer.getAndIncrement () );
                }
            } );
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5,
                1000, TimeUnit.MILLISECONDS, queue);
        executor.prestartAllCoreThreads ();
        executor.shutdown ();
        executor.awaitTermination ( 5, TimeUnit.SECONDS );

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
