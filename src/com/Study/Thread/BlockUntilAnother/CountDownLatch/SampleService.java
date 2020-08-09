package com.Study.Thread.BlockUntilAnother.CountDownLatch;


import java.util.concurrent.CountDownLatch;

public class SampleService {
    public void method1(CountDownLatch downLatch){
        System.out.println("执行第一段");
        downLatch.countDown();
        System.out.println("执行剩余");
        for (int i=0; i<5; i++){
            System.out.println("TaskA" + "==>" + i);
        }
    }
}
