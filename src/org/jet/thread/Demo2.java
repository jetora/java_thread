package org.jet.thread;

public class Demo2 implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("thread running....");
        }
    }
    public static void main(String[] args){
        Thread t = new Thread(new Demo2());
        t.run();
    }
}
