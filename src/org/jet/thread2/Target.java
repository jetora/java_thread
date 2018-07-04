package org.jet.thread2;

public class Target implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+" thread is running...");
        }

    }
}
