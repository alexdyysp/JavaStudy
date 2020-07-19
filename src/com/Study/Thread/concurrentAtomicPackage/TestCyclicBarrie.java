package com.Study.Thread.concurrentAtomicPackage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrie {
    static CyclicBarrier cyclicBarrier;

    public static void main(String[]args){
        cyclicBarrier = new CyclicBarrier(20,new Runnable() {

            @Override
            public void run() {
                System.out.println("全部就绪，开始登车");
            }
        });
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "--到达车门--" + "到达时间是" + System.currentTimeMillis());

                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--已登车--" + "启动时间是" + System.currentTimeMillis());
                }
            }).start();
        }
    }
}