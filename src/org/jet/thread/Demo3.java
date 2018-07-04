package org.jet.thread;

public class Demo3 {
    public static void main(String[] args){

        new Thread(){
            @Override
            public void run() {
                System.out.println("thread1 running");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 running");
            }
        }).start();
    }
}
