package com.Study.Stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args){
        // 调用parallel
        //IntStream.range(1,100).parallel().peek(ParallelStream::debug).count();

        // 实现一个效果：先串行再并行
        /* 多次调用parallel/sequential，以最后一次调用为准
        IntStream.range(1,100).parallel().peek(ParallelStream::debug)
                    .sequential().peek(ParallelStream::debug).count();
        */
        /* 并行流使用的线程池：ForkJoinPool.commonPool
        默认线程数：当前CPU个数

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","4");
        IntStream.range(1,10).parallel().peek(ParallelStream::debug).count();
        */

        // 自定义线程池，防止任务被阻塞
        ForkJoinPool pool = new ForkJoinPool(4);
        pool.submit(()->IntStream.range(1,100).parallel().peek(ParallelStream::debug).count());
        pool.shutdown();
        synchronized (pool){
            try {
                pool.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void debug(int i){
        System.out.println(Thread.currentThread().getName()+" debug " + i);
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void debug2(int i){
        System.out.println("debug" + i);
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
