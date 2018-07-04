package org.jet.thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Demo8 {
    private static int value;

    /**
     * synchronized 放在普通方法上，内置锁就是当前类得是里
     * @return
     */
    public synchronized int getNext(){
        return value++;
    }

    /**
     * 修饰静态方法，内置锁是当前得Class字节码对象
     * @return
     */
    public synchronized static int getPrevious(){
        return value--;
    }

    /**
     * 对于同步方法块，锁是Synchronized括号里配置的对象
     * @return
     */
    public int xx(){
        synchronized (this){
            if (value>1){
                return 1;
            }else {
                return -1;
            }
        }
    }


    public static void main(String[] args){
        Demo8 demo = new Demo8();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 running"+ demo.getNext());
                System.out.println("thread1 running"+ demo.xx());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 running"+ demo.getNext());
                System.out.println("thread2 running"+ demo.xx());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3 running"+ demo.getNext());
                System.out.println("thread3 running"+ demo.xx());
            }
        }).start();


    }

}
