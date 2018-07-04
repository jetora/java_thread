package org.jet.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo4 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("thread1 running");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args){
        Demo4 d = new Demo4();
        FutureTask<Integer> task = new FutureTask<>(d);
        Thread t = new Thread(task);
        t.start();
        try {
            System.out.println("thread2 running");
            Integer result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
