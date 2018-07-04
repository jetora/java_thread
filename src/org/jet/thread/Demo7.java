package org.jet.thread;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo7 {

    public int add(List<Integer> values){
        values.stream().forEach(System.out::println);
        values.parallelStream().forEach(System.out::println);
        return values.parallelStream().mapToInt(a -> a).sum();
    }

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

        List<Integer> values = Arrays.asList(10,20,30,40);
        int res = new Demo7().add(values);
        System.out.println(res);


    }
}
