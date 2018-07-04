package org.jet.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo6 {

    public static void main(String[] args){

        ExecutorService threadpool = Executors.newFixedThreadPool(10);

        for (int i=0;i<100;i++){
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" thread is running...");
                }
            });
        }

        threadpool.shutdown();


    }
}
