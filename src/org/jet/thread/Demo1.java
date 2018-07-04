package org.jet.thread;

public class Demo1 extends Thread{


    public Demo1(String name){
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName()+"线程执行了...");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
    public static void  main(String[] args){
        Demo1 t1 = new Demo1("thread1");
        Demo1 t2 = new Demo1("thread2");
        t1.start();
        t2.start();

        t1.interrupt();
    }
}
